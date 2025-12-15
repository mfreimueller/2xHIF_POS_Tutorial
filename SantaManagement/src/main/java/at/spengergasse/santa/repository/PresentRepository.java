package at.spengergasse.santa.repository;

import at.spengergasse.santa.domain.Present;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PresentRepository extends Repository<Present> {

    public PresentRepository(Connection connection) {
        super(connection, Present.class, Present::new);
    }

    public Present createOne(Present present) throws SQLException {
        final String sql = "INSERT INTO Presents (priority, status) VALUES (?, ?)";

        try (final PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, present.getPriority().ordinal());
            stmt.setInt(2, present.getStatus().ordinal());

            stmt.executeUpdate();

            var generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                present.setId(generatedKeys.getLong(1));
            }
        }

        return present;
    }

    public Present updateOne(Present present) throws SQLException {
        final String sql = "UPDATE Presents SET priority = ?, status = ? WHERE id = ?";

        try (final PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, present.getPriority().ordinal());
            stmt.setInt(2, present.getStatus().ordinal());
            stmt.setLong(3, present.getId());

            stmt.executeUpdate();
        }

        return present;
    }
}
