package postgresProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private final String driver;
    private final String dbName;
    private final String connectionURL;
    private final String ssl;
    private final String username;
    private final String password;

    public DatabaseConnection() {
        driver = "org.postgresql.Driver";
       // connectionURL = "jdbc:mysql://localhost:3306/";
        connectionURL = "jdbc:postgresql://localhost:5432/postgres";
        dbName = "postgres";
        ssl = "?autoReconnect=true&useSSL=false";
        username = "postgres";
        password = "1234";
    }

    public Connection getConnection() throws Exception {
        Class.forName(driver);

        return DriverManager.getConnection(connectionURL , username, password);
    }

    public static void main(String[] args) {
        DatabaseConnection db = new DatabaseConnection();
        try {
            Connection conn = db.getConnection();
            System.out.println("Database successfully connected!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}