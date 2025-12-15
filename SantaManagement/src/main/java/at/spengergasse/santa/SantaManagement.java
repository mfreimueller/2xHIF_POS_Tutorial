package at.spengergasse.santa;

import at.spengergasse.santa.foundation.Config;
import at.spengergasse.santa.foundation.ConnectionProvider;

import java.sql.SQLException;

public class SantaManagement {
    static void main() throws SQLException {
        var config = new Config();
        try (var connection = new ConnectionProvider().openConnection(config.getConnectionString(), config.getUsername(), config.getPassword())) {

        }
    }

}
