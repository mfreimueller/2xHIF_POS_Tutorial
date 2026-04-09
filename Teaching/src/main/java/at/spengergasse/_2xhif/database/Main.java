package at.spengergasse._2xhif.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    static void main(String[] args) {
        try {
            // The newInstance() call is a work around for some
            // broken Java implementations

            // Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").getDeclaredConstructor().newInstance();



            // jdbc:sqlserver://127.0.0.1\localhost:1433;database=SchulDb;
            //                  encrypt=true;trustServerCertificate=true;
            //                  user=sa;password=SqlServer2019;
            Connection con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1\\localhost:1433;database=SchulDb;encrypt=true;trustServerCertificate=true;user=sa;password=SqlServer2019;");

        } catch (Exception ex) {
            System.err.println("Load Driver problems: " + ex.getMessage());
        }
    }

}
