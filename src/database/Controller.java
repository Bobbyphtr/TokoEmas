package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet rs;
    private ResultSetMetaData rsmt;

    public Controller() {
        Connection conn = ConnectionManager.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public DefaultTableModel getPelanggan() {
        String query = "SELECT * from customer";
        try {
            rs = statement.executeQuery(query);
            rsmt = rs.getMetaData();

            Vector data = new Vector();

            int c = rsmt.getColumnCount();

            Vector column = new Vector(c);
            for (int i = 1; i <= c; i++) {
                column.add(rsmt.getColumnName(i)); //Nama Kolom untuk sementara ambil dari database
            }

            while (rs.next()) {
                Vector row = new Vector();
                for (int i = 1; i <= c; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            
            return new DefaultTableModel(data, column);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
