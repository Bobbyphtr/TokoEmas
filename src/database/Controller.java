package database;

import POJO.Pelanggan;
import POJO.Produk;
import POJO.SupplierData;
import POJO.User;
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
import javax.swing.DefaultListModel;
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

    public static User getUserbyUsername(String username) {
        String query = "SELECT * FROM user WHERE username = ? ";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, username);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"));
                return user;
            }

        } catch (SQLException ex) {
            System.out.println("Gagal mengakses user");
            ex.printStackTrace();
        }
        return null;
    }

    public static DefaultTableModel getPelanggan() {
        String query = "SELECT * from customer WHERE id != 0";
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
                    if (rs.getObject(i) != null) {
                        if (rs.getString(i).equals("true") || rs.getString(i).equals("false")) {
                            row.add(rs.getBoolean(i));
                        } else {
                            row.add(rs.getString(i));
                        }
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

    public static void deletePelanggan(int id) {
        try {
            String query = "DELETE FROM customer WHERE customer.id = ?";
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal menghapus pelanggan");
            ex.printStackTrace();
        }
    }

    public static void updatePelanggan(Pelanggan pelanggan) {
        String query = "UPDATE customer SET nama = ?, email = ?, alamat = ?, no_telp = ?,"
                + "status_loyal = ?, bonus = ?, deskripsi_bonus = ? WHERE id = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, pelanggan.getNama());
            preparedStatement.setString(2, pelanggan.getEmail());
            preparedStatement.setString(3, pelanggan.getAlamat());
            preparedStatement.setString(4, pelanggan.getNo_telp());
            
            if (pelanggan.isStatus_loyal()) preparedStatement.setString(5, "true");
            else preparedStatement.setString(5, "false");
            
            preparedStatement.setInt(6, pelanggan.getBonus());
            preparedStatement.setString(7, pelanggan.getDeskripsi_bonus());
            
            preparedStatement.setInt(8, pelanggan.getId());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update pelanggan gagal");
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

    public static DefaultListModel getAllKategori() {
        String query = "SELECT * FROM kategori";
        try {
            rs = statement.executeQuery(query);
            DefaultListModel listModel = new DefaultListModel();
            while (rs.next()) {
                listModel.addElement(rs.getString("nama"));
            }
            return listModel;
        } catch (SQLException ex) {
            System.out.println("Gagal mengakses kategori");
            ex.printStackTrace();
        }
        return null;
    }

    public static void addKategori(String nama) {
        String query = "INSERT INTO kategori (nama) VALUES (?)";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal tambah kategori");
            ex.printStackTrace();
        }

    }

    public static void deleteKategori(String nama) {
        String query = "DELETE FROM kategori WHERE nama = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void updateKategori(String nama, String index) {
        String query = "UPDATE kategori SET nama = ? WHERE nama = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, index);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update kategori gagal");
            ex.printStackTrace();
        }
    }

    public static DefaultListModel getSupplierModel() {
        String query = "SELECT * FROM supplier";
        try {
            rs = statement.executeQuery(query);
            DefaultListModel listModel = new DefaultListModel();
            while (rs.next()) {
                listModel.addElement(rs.getString("nama"));
            }
            return listModel;
        } catch (SQLException ex) {
            System.out.println("Gagal mengakses supplier");
            ex.printStackTrace();
        }
        return null;
    }

    public static Vector getAllSupplier() {
        String query = "SELECT * FROM supplier";
        try {
            rs = statement.executeQuery(query);
            Vector data = new Vector();
            while (rs.next()) {
                SupplierData newSupplier = new SupplierData();
                newSupplier.setId(rs.getInt("id"));
                newSupplier.setNama(rs.getString("nama"));
                newSupplier.setAlamat(rs.getString("alamat"));
                newSupplier.setNotelp(rs.getString("no_telp"));
                data.add(newSupplier);
            }
            return data;
        } catch (SQLException ex) {
            System.out.println("Gagal mengakses data supplier");
            ex.printStackTrace();
        }
        return null;
    }

    public static void addSupplier(SupplierData supplier) {
        String query = "INSERT INTO supplier (nama, alamat, no_telp) VALUES (? , ?, ?)";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, supplier.getNama());
            preparedStatement.setString(2, supplier.getAlamat());
            preparedStatement.setString(3, supplier.getNotelp());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal masukan supplier");
            ex.printStackTrace();
        }
    }

    public static void updateSupplier(int id, String nama, String alamat, String noTelp) {
        String query = "UPDATE supplier SET nama = ?, alamat = ?, no_telp = ? WHERE id = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, nama);
            preparedStatement.setString(2, alamat);
            preparedStatement.setString(3, noTelp);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update supplier gagal");
            ex.printStackTrace();
        }
    }

    public static void deleteSupplier(int id) {
        String query = "DELETE FROM supplier WHERE id = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static DefaultTableModel getAllStaf() {
        String query = "SELECT * from pekerja";
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
                    if (rs.getObject(i) != null) {
                        row.add(rs.getString(i));
                    } else {
                        row.add("-");
                    }

                }
                data.add(row);
            }

            return new DefaultTableModel(data, column) {
                private final Class<?>[] columnClasses = {Integer.class, String.class, String.class, String.class, String.class, Integer.class, String.class, Integer.class, String.class};

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

    public static void deleteStafbyId(int id) {
        String query = "DELETE FROM pekerja WHERE id = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void updateStaf(int id, ) {
//
//    }

    public static DefaultTableModel getAllProduk() {
        String query = "SELECT * FROM barang WHERE status = 'INSTOCK'";
        try {
            rs = statement.executeQuery(query);
            rsmt = rs.getMetaData();

            Vector data = new Vector();

            Vector column = new Vector();

            column.add("ID");
            column.add("Nama");
            column.add("Deskripsi");
            column.add("Berat");
            column.add("Karat");
            column.add("Status");
            column.add("Tipe");
            column.add("Harga Beli");
            column.add("Tanggal Beli");
            column.add("Aksi");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDouble("berat"));
                row.add(rs.getDouble("karat"));
                row.add(rs.getString("status"));
                row.add(rs.getString("tipe_barang"));
                row.add(rs.getInt("harga_beli"));
                row.add(rs.getString("tanggal_beli"));
                data.add(row);
            }

            return new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == columnIdentifiers.size() - 1) {
                        return true;
                    }
                    return false;
                }

            };
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void getProdukbyId(int id) {
        String query = "SELECT * FROM barang WHERE id = ?";
    }

    public static void deleteProduk(int id) {
        String query = "DELETE FROM barang WHERE id = ? ";
    }

    public static void addProduk(Produk produk) {
        String query = "INSERT INTO barang (nama, deskripsi, berat, karat, status, tipe_barang,"
                + "id_kategori, id_supplier, harga_beli, tanggal_beli) VALUES "
                + "(? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    public static void updateProduk(int id) {
        String query = "UPDATE barang SET nama = ?, deskripsi = ?, berat = ?, karat = ?, status = ?, "
                + "tipe_barang = ?, id_kategori = ?, id_supplier = ?, harga_beli = ?, tanggal_beli = ?"
                + "WHERE id = ?";
    }

}
