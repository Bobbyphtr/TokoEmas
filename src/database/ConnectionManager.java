package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Xenon
 */
public class ConnectionManager {
    
    private Connection conn;

    public ConnectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/toko_emas", "root", "");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            System.out.println("Error: " + ex);
        }
    }

    public Connection getConnection() {
        System.out.println(conn != null ? "Connected to Database" : "Not Connected to Database");
        return conn;
    }

    public static void main(String[] args) {
        ConnectionManager cm = new ConnectionManager();
        Connection testConn = cm.getConnection();
    }
}
