package at.spengergasse.santa.repository;

import at.spengergasse.santa.domain.AbstractEntity;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class Repository<T extends AbstractEntity> {
    private final Connection connection;
    private final Class<? extends T> clazz;
    private final Supplier<T> ctor;

    public Repository(Connection connection, Class<? extends T> clazz, Supplier<T> ctor) {
        this.connection = connection;
        this.clazz = clazz;
        this.ctor = ctor;
    }

    protected Connection getConnection() {
        return connection;
    }

    public List<T> findAll() throws SQLException {
        var elements = new ArrayList<T>();
        final var fields = clazz.getDeclaredFields();
        final var attributeList = Arrays.stream(fields)
                .filter(this::isPrimitive)
                .map(Field::getName)
                .collect(Collectors.joining(","));

        final String sql = "SELECT %s FROM %ss".formatted(attributeList, clazz.getName());

        try (final PreparedStatement stmt = connection.prepareStatement(sql);
             final ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // call default constructor
                T element = ctor.get();

                for (var field : fields) {
                    if (isPrimitive(field)) {
                        try {
                            setFieldValue(element, field, rs);
                        } catch (IllegalAccessException e) {
                            // TODO LOG
                        }
                    }
                }

                elements.add(element);
            }
        }

        return elements;
    }

    public T createOne(T element) throws SQLException {
        final var fields = clazz.getDeclaredFields();
        final var attributes = Arrays.stream(fields)
                .filter(this::isPrimitive)
                .filter(f -> !f.getName().equals("id"))
                .toList();

        final var attributeList = attributes.stream()
                .map(Field::getName)
                .collect(Collectors.joining(","));
        final var placeholders = attributes.stream()
                .map(_ -> "?")
                .collect(Collectors.joining(","));

        final String sql = "INSERT INTO %ss (%s) VALUES (%s)".formatted(clazz.getName(), attributeList, placeholders);

        try (final PreparedStatement stmt = connection.prepareStatement(sql)) {
            for (int idx = 0; idx < attributes.size(); idx++) {
                setStmtValue(idx + 1, stmt, element, attributes.get(idx));
            }

            stmt.executeUpdate();

            var generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                element.setId(generatedKeys.getLong(1));
            }
        } catch (IllegalAccessException e) {
            // TODO LOG
        }

        return element;
    }

    private void setStmtValue(int idx, PreparedStatement stmt, T element, Field field) throws SQLException, IllegalAccessException {
        var type = field.getType();

        if (Short.class.equals(type)) {
            stmt.setShort(idx, field.getShort(element));
        } else if (Integer.class.equals(type)) {
            stmt.setInt(idx, field.getInt(element));
        } else if (Long.class.equals(type)) {
            stmt.setLong(idx, field.getLong(element));
        } else if (Byte.class.equals(type)) {
            stmt.setByte(idx, field.getByte(element));
        } else if (String.class.equals(type) || Character.class.equals(type)) {
            stmt.setString(idx, (String) field.get(element));
        } else if (Boolean.class.equals(type)) {
            stmt.setBoolean(idx, field.getBoolean(element));
        } else if (Enum.class.equals(type)) {
            var constant = (Enum<?>) field.get(field.getName());
            int ordinal = constant.ordinal();

            stmt.setInt(idx, ordinal);
        }
    }

    private void setFieldValue(T element, Field field, ResultSet rs) throws SQLException, IllegalAccessException {
        var type = field.getType();

        if (Short.class.equals(type)) {
            field.setShort(element, rs.getShort(field.getName()));
        } else if (Integer.class.equals(type)) {
            field.setInt(element, rs.getInt(field.getName()));
        } else if (Long.class.equals(type)) {
            field.setLong(element, rs.getLong(field.getName()));
        } else if (Byte.class.equals(type)) {
            field.setByte(element, rs.getByte(field.getName()));
        } else if (String.class.equals(type) || Character.class.equals(type)) {
            field.set(element, rs.getString(field.getName()));
        } else if (Boolean.class.equals(type)) {
            field.setBoolean(element, rs.getBoolean(field.getName()));
        } else if (Enum.class.equals(type)) {
            var constants = type.getEnumConstants();
            int ordinal = rs.getInt(field.getName());

            field.set(element, constants[ordinal]);
        }
    }

    private boolean isPrimitive(Field f) {
        var type = f.getType();

        return Short.class.equals(type) ||
                Integer.class.equals(type) ||
                Long.class.equals(type) ||
                Byte.class.equals(type) ||
                String.class.equals(type) ||
                Character.class.equals(type) ||
                Boolean.class.equals(type) ||
                Enum.class.equals(type);

    }

}
