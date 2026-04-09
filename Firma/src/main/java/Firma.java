import java.sql.*;

public class Firma {

    static void main() throws SQLException {
        // final String connectionString = "jdbc:mysql://localhost:3306/firma";
        final String connectionString = "jdbc:mariadb://localhost:3306/firma";
        final Connection connection = DriverManager.getConnection(connectionString, "root", null);

        try {
            System.out.println("All customers:");
            readCustomers(connection);

            System.out.println("\nOnly customers from Berlin:");
            readCustomersFromCity(connection, "Berlin");

            System.out.println("\nSQL injection:");
            readCustomersFromCitySqlInjectionVersion(connection, "' OR '1' = '1");

            System.out.println("\nSQL injection fixed:");
            readCustomersFromCity(connection, "' OR '1' = '1");
        } finally {
            connection.close();
        }

        // is equivalent to...
        // try (final Connection conn = DriverManager.getConnection(connectionString, "root", null)) {
            // here be dragons...
            // readCustomers(conn);
        // }
    }

    static void readCustomers(final Connection connection) throws SQLException {
        final Statement stmt = connection.createStatement();
        try {
            boolean isSuccess = stmt.execute("SELECT id, name, email, stadt FROM kunden;");
            if (!isSuccess) {
                System.err.println("SQL query returned no results.");
                return;
            }

            // [0, 1, 2, 3] => 0xaf45 + sizeof(int32) => index 1: 1

            try (final ResultSet resultSet = stmt.getResultSet()) {
                printResultSet(resultSet);
            }
        } finally {
            stmt.close();
        }
    }

    static void readCustomersFromCity(final Connection connection, final String city) throws SQLException {
        final String sql = "SELECT * FROM kunden WHERE stadt = ?;";
        try (final PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, city);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                printResultSet(resultSet);
            }
        }
    }

    static void readCustomersFromCitySqlInjectionVersion(final Connection connection, final String city) throws SQLException {
        final String sql = "SELECT * FROM kunden WHERE stadt = '" + city +"';";
        try (final Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(sql)) {
                printResultSet(resultSet);
            }
        }
    }

    static void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            final int id = resultSet.getInt(1);
            final String name = resultSet.getString(2);
            final String email = resultSet.getString("email");
            final String stadt = resultSet.getString("stadt");

            System.out.printf("ID: %d | Name: %s | Email: %s | Stadt: %s\n", id, name, email, stadt);
        }
    }

}
