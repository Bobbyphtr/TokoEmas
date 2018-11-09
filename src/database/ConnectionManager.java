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

    public static ConnectionManager conMgr = new ConnectionManager();
    private static Connection conn;

    private ConnectionManager() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/toko_emas", "root", "");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ConnectionManager getInstance() {
        return conMgr;
    }

    public static Connection getConnection() {
        System.out.println(conn != null ? "Connected to Database" : "Not Connected to Database");
        return conn;
    }

    public static void main(String[] args) {
        Connection testCon = ConnectionManager.getConnection();
    }
}
