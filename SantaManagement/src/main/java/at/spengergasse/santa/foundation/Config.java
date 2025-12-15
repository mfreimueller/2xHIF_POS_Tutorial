package at.spengergasse.santa.foundation;

public class Config {
    public String getConnectionString() {
        // MariaDB: jdbc:mariadb://HOST:PORT/DATENBANK
        // MSSQL: jdbc:sqlserver://localhost:1433;databaseName=SchoolDB;encrypt=false
        return "";
    }

    public String getUsername() {
        return "sa";
    }

    public String getPassword() {
        return "SqlServer2019";
    }
}
