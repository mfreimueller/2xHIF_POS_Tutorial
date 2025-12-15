package at.spengergasse.santa.repository;

import at.spengergasse.santa.domain.Elf;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ElfRepository {
    private final Connection connection;

    public ElfRepository(Connection connection) {
        this.connection = connection;
    }

    public List<Elf> findAll() throws SQLException {
        var elves = new ArrayList<Elf>();

        final String sql = "SELECT * FROM Elves";

        try (final PreparedStatement stmt = connection.prepareStatement(sql);
             final ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                final String name = rs.getString("name");
                final int age = rs.getInt("age");
            }
        }

        return elves;
    }

    public Elf createOne(Elf elf) throws SQLException {
        final String sql = "INSERT INTO Elves (name, age) VALUES (?, ?)";

        try (final PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, elf.getName());
            stmt.setInt(2, elf.getAge());

            stmt.executeUpdate();

            var generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                elf.setId(generatedKeys.getLong(1));
            }
        }

        return elf;
    }

}
