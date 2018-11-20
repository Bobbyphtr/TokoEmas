package database;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet rs;
    private static ResultSetMetaData rsmt;
    private static Connection conn;

    public Controller() {
        ConnectionManager cm = new ConnectionManager();
        conn = cm.getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DefaultTableModel getPelanggan() {
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
                    if(rs.getObject(i) != null){
                        if (rs.getString(i).equals("true") || rs.getString(i).equals("false")) row.add(rs.getBoolean(i));
                        else row.add(rs.getString(i));
                    } else {
                        row.add("-");
                    }

                }
                data.add(row);
            }

            return new DefaultTableModel(data, column) {
                private final Class<?>[] columnClasses = {String.class, String.class, String.class, String.class, String.class, Boolean.class, String.class, String.class};

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

                @Override
                public Class<?> getColumnClass(int col) {
                    return columnClasses[col];
                }

            };
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void addPelanggan(String nama, String email, String alamat, String no_telp, String status_loyal, int bonus, String deskripsi_bonus) {
        
        try {
            String query = "INSERT INTO customer (nama,email,alamat,no_telp,status_loyal,bonus,deskripsi_bonus) VALUES ( ? , ? , ? , ? , ? , ? , ? );";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, alamat);
            preparedStatement.setString(4, no_telp);
            preparedStatement.setString(5, status_loyal);
            preparedStatement.setInt(6, bonus);
            preparedStatement.setString(7, deskripsi_bonus);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal tambah pelanggan");
            ex.printStackTrace();
        }
    }
    
    public static String[] getDateAndTime() {
        String[] array = new String[2];
        String time = "HH:mm";
        String date = "dd-MM-YYYY";
        Calendar cal = Calendar.getInstance();
        
        DateFormat dateFormat = new SimpleDateFormat(time);
        array[0] = dateFormat.format(cal.getTime());
        
        dateFormat = new SimpleDateFormat(date);
        array[1] = dateFormat.format(cal.getTime());
        
        
        return array;
    }
}
