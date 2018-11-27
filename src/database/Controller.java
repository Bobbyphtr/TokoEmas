package database;

import POJO.KategoriData;
import POJO.Pelanggan;
import POJO.Produk;
import POJO.Staf;
import POJO.SupplierData;
import POJO.Transaksi;
import POJO.User;
import java.awt.Component;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

public class Controller {

    private static PreparedStatement preparedStatement;
    private static Statement statement;
    private static ResultSet rs;
    private static ResultSetMetaData rsmt;
    private static Connection conn;

    private static final int TRIAL_DAY = 27;
    private static final int TRIAL_MONTH = 11;
    private static final int TRIAL_YEAR = 2018;
    private static final String TRIAL_DATE = "2018-11-27";

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

    public static DefaultTableModel getPelangganDialog() {
        String query = "SELECT * from customer WHERE id != 0";
        try {
            rs = statement.executeQuery(query);
            rsmt = rs.getMetaData();

            Vector data = new Vector();

            Vector column = new Vector();
            column.add("ID");
            column.add("Nama"); //Nama Kolom untuk sementara ambil dari database

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                data.add(row);
            }

            return new DefaultTableModel(data, column);
        } catch (SQLException ex) {
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
                row.add(rs.getString("id"));
                row.add(rs.getString("nama"));
                row.add(rs.getString("email"));
                row.add(rs.getString("alamat"));
                row.add(rs.getString("no_telp"));
                row.add(rs.getString("status_loyal"));
                row.add(rs.getInt("bonus"));
                row.add(rs.getString("deskripsi_bonus"));
                data.add(row);
            }

            return new DefaultTableModel(data, column) {
                private final Class<?>[] columnClasses = {String.class, String.class, String.class, String.class, String.class, String.class, Integer.class, String.class};

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

            if (pelanggan.isStatus_loyal()) {
                preparedStatement.setString(5, "true");
            } else {
                preparedStatement.setString(5, "false");
            }

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

    public static DefaultComboBoxModel getSupplierComboBoxModel() {
        String query = "SELECT * FROM supplier";
        try {
            rs = statement.executeQuery(query);
            DefaultComboBoxModel listModel = new DefaultComboBoxModel();
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

    public static DefaultComboBoxModel getKategoriComboBoxModel() {
        String query = "SELECT * FROM kategori";
        try {
            rs = statement.executeQuery(query);
            DefaultComboBoxModel listModel = new DefaultComboBoxModel();
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

    public static Vector getKategori() {
        String query = "SELECT * FROM kategori";
        try {
            rs = statement.executeQuery(query);
            Vector data = new Vector();
            while (rs.next()) {
                KategoriData kategori = new KategoriData(rs.getInt("id"), rs.getString("nama"));
                data.add(kategori);
            }
            return data;
        } catch (SQLException ex) {
            System.out.println("Gagal mengakses kategori");
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

    public static DefaultTableModel getStafDialog() {
        String query = "SELECT * from pekerja";
        try {
            rs = statement.executeQuery(query);
            rsmt = rs.getMetaData();

            Vector data = new Vector();

            Vector column = new Vector();
            column.add("ID");
            column.add("Nama"); //Nama Kolom untuk sementara ambil dari database

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                data.add(row);
            }

            return new DefaultTableModel(data, column);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
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

    public static void addStaf(Staf staf) {
        String query = "INSERT INTO pekerja (nama, email, alamat, no_telp, gaji, posisi, reward, deskripsi_reward) "
                + "VALUES (? , ?, ?, ?, ?, ? , ?, ?)";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, staf.getNama());
            preparedStatement.setString(2, staf.getEmail());
            preparedStatement.setString(3, staf.getAlamat());
            preparedStatement.setString(4, staf.getNoTelp());
            preparedStatement.setInt(5, staf.getGaji());
            preparedStatement.setString(6, staf.getPosisi());
            preparedStatement.setInt(7, 0);
            preparedStatement.setString(8, "Tidak ada");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Gagal masukan staf");
            ex.printStackTrace();
        }
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

    public static void updateStaf(Staf staf) {
        String query = "UPDATE pekerja SET nama = ?, email = ?, alamat = ?, no_telp = ?, gaji = ?,"
                + "posisi = ?, reward = ?, deskripsi_reward = ? WHERE id = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, staf.getNama());
            preparedStatement.setString(2, staf.getEmail());
            preparedStatement.setString(3, staf.getAlamat());
            preparedStatement.setString(4, staf.getNoTelp());
            preparedStatement.setInt(5, staf.getGaji());
            preparedStatement.setString(6, staf.getPosisi());
            preparedStatement.setInt(7, staf.getReward());
            preparedStatement.setString(8, staf.getDekripsiReward());

            preparedStatement.setInt(9, staf.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update staf gagal");
            ex.printStackTrace();
        }
    }

    /*
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
            column.add("Tipe");
            column.add("Harga Beli");
            column.add("Aksi");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDouble("berat"));
                row.add(rs.getDouble("karat"));
                row.add(rs.getString("tipe_barang"));
                row.add(rs.getInt("harga_beli"));
                data.add(row);

            }

            return new DefaultTableModel(data, column) {
                private final Class<?>[] columnClasses = {Integer.class, String.class, String.class, Double.class, Double.class, String.class, Integer.class};

                @Override
                public Class<?> getColumnClass(int col) {
                    return columnClasses[col];
                }

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
     */
    public static DefaultTableModel getAllProduk() {

        String query = "SELECT barang.id, barang.nama, deskripsi, berat, karat, tipe_barang,"
                + " kategori.nama as kategori,  supplier.nama as supplier, harga_beli, tanggal_beli "
                + "FROM barang "
                + " LEFT JOIN "
                + "kategori on kategori.id = barang.id_kategori"
                + " LEFT JOIN "
                + "supplier on supplier.id = barang.id_supplier WHERE status = 'INSTOCK'";

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
            column.add("Tipe");
            column.add("kategori");
            column.add("supplier");
            column.add("Harga Beli");
            column.add("tanggal beli");
            column.add("Aksi");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDouble("berat"));
                row.add(rs.getDouble("karat"));
                row.add(rs.getString("tipe_barang"));
                row.add(rs.getString("kategori") == null ? "Tidak ada kategori" : rs.getString("kategori"));
                row.add(rs.getString("supplier") == null ? "Tidak ada supplier/dihapus" : rs.getString("supplier"));
                row.add(rs.getInt("harga_beli"));
                row.add(rs.getDate("tanggal_beli"));
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

    public static DefaultTableModel getAllProdukPanel() {

        String query = "SELECT barang.id, barang.nama, deskripsi, berat, karat, status, tipe_barang,"
                + " kategori.nama as kategori,  supplier.nama as supplier, harga_beli, tanggal_beli "
                + "FROM barang "
                + " LEFT JOIN "
                + "kategori on kategori.id = barang.id_kategori"
                + " LEFT JOIN "
                + "supplier on supplier.id = barang.id_supplier";

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
            column.add("kategori");
            column.add("supplier");
            column.add("Harga Beli");
            column.add("tanggal beli");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getInt("id"));
                row.add(rs.getString("nama"));
                row.add(rs.getString("deskripsi"));
                row.add(rs.getDouble("berat"));
                row.add(rs.getDouble("karat"));
                row.add(rs.getString("status"));
                row.add(rs.getString("tipe_barang"));
                row.add(rs.getString("kategori") == null ? "Tidak ada kategori" : rs.getString("kategori"));
                row.add(rs.getString("supplier") == null ? "Tidak ada supplier/dihapus" : rs.getString("supplier"));
                row.add(rs.getInt("harga_beli"));
                row.add(rs.getDate("tanggal_beli"));
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

    public static void updateStatusProduk(int id) {
        String query = "UPDATE `barang` SET `status` = 'SOLD' WHERE `barang`.`id` = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            System.out.println("UPDATE SOLD");
        } catch (SQLException ex) {
            System.out.println("Update status produk gagal");
            ex.printStackTrace();
        }
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

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, produk.getNama());
            preparedStatement.setString(2, produk.getDeskripsi());
            preparedStatement.setDouble(3, produk.getBerat());
            preparedStatement.setInt(4, produk.getKarat());
            preparedStatement.setString(5, produk.getStatus());
            preparedStatement.setString(6, produk.getTipeBarang());
            preparedStatement.setInt(7, produk.getIdKategori());
            preparedStatement.setInt(8, produk.getIdSupplier());
            preparedStatement.setInt(9, produk.getHargaBeli());
            preparedStatement.setDate(10, produk.getTanggalBeli());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update produk gagal");
            ex.printStackTrace();
        }

    }

    public static void updateProduk(Produk produk) {

        String query = "UPDATE barang SET nama = ?, deskripsi = ?, berat = ?, karat = ?, status = ?, "
                + "tipe_barang = ?, id_kategori = ?, id_supplier = ?, harga_beli = ?, tanggal_beli = ?"
                + "WHERE id = ?";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, produk.getNama());
            preparedStatement.setString(2, produk.getDeskripsi());
            preparedStatement.setDouble(3, produk.getBerat());
            preparedStatement.setDouble(4, (double) produk.getKarat());
            preparedStatement.setString(5, produk.getStatus());
            preparedStatement.setString(6, produk.getTipeBarang());
            if (produk.getIdKategori() == 0) {
                preparedStatement.setNull(7, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(7, produk.getIdKategori());
            }
            if (produk.getIdSupplier() == 0) {
                preparedStatement.setNull(8, java.sql.Types.INTEGER);
            } else {
                preparedStatement.setInt(8, produk.getIdSupplier());
            }
            preparedStatement.setInt(9, produk.getHargaBeli());
            preparedStatement.setDate(10, produk.getTanggalBeli());
            preparedStatement.setInt(11, produk.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update produk gagal");
            ex.printStackTrace();
        }
    }

    public static void addKarat(Double karatBaru) {
        String query = "INSERT INTO `karat` (`value`) VALUES (' ? ');";

        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setDouble(1, karatBaru);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update karat gagal");
            ex.printStackTrace();
        }
    }

    public static DefaultComboBoxModel getKarat() {
        String query = "SELECT * FROM `karat`";
        try {
            rs = statement.executeQuery(query);
            DefaultComboBoxModel listModel = new DefaultComboBoxModel();
            while (rs.next()) {
                listModel.addElement(rs.getDouble("value"));
            }
            return listModel;
        } catch (SQLException ex) {
            System.out.println("Gagal mengakses karat");
            ex.printStackTrace();
        }
        return null;
    }

    public static DefaultTableModel getRankingPegawai() {
        String query = "SELECT nama, SUM(profit) as total\n"
                + "from (SELECT pekerja.nama as nama, (harga_jual - harga_beli) as profit from transaksi, barang, pekerja where MONTH( tanggal_jual ) = ? AND YEAR( tanggal_jual ) = ? AND transaksi.id_barang = barang.id AND transaksi.id_pekerja = pekerja.id) as list_profit \n"
                + "GROUP BY nama ORDER BY total DESC";
        Calendar cal = Calendar.getInstance();
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, cal.get(Calendar.MONTH));
            preparedStatement.setInt(2, cal.get(Calendar.YEAR));
            rs = preparedStatement.executeQuery();

            Vector data = new Vector();

            Vector column = new Vector();

            column.add("Ranking Pegawai");

            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString("nama"));
                data.add(row);

            }

            return new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }

            };
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static DefaultTableModel getTransaksi() {

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);
        String query = "SELECT transaksi.tanggal_jual, transaksi.harga_jual FROM `transaksi` WHERE 1";

        try {
            rs = statement.executeQuery(query);
            rsmt = rs.getMetaData();

            Vector data = new Vector();

            Vector column = new Vector();

            column.add("Tindakan");
            column.add("Judul");

            while (rs.next()) {
                Vector row = new Vector();
                String isi = rs.getString(1) + " - " + kursIndonesia.format(rs.getInt(2));
                row.add("Tindakan");
                row.add(isi);
                data.add(row);

            }

            return new DefaultTableModel(data, column) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return true;
                }

            };
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String getTransaksiCount() {
        String query = "SELECT Count(transaksi.id_barang) as jumlah_transaksi FROM `transaksi` WHERE tanggal_jual = ?";
        try {
            preparedStatement = conn.prepareStatement(query);
            Calendar cal = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            //preparedStatement.setString(1, df.format(cal.getTime()));
            preparedStatement.setString(1, TRIAL_DATE);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("jumlah_transaksi");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void addTransaksi(Transaksi transaksi) {
        String query = "INSERT INTO transaksi VALUE ( ? , ? , ? , ? , ? , ? )";
        try {
            preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, transaksi.getIdBarang());
            preparedStatement.setInt(2, transaksi.getIdCustomer());
            preparedStatement.setInt(3, transaksi.getIdPekerja());
            preparedStatement.setString(4, transaksi.getMetodePembayaran());
            preparedStatement.setInt(5, transaksi.getHargaJual());
            preparedStatement.setDate(6, transaksi.getTanggalJual());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Update produk gagal");
            ex.printStackTrace();
        }
    }

    public static String getProfitHariIni() {
        String query = "SELECT SUM(profit) as profit_hari_ini from "
                + "(SELECT barang.harga_beli as harga_beli, harga_jual, tanggal_jual, (harga_jual - harga_beli) "
                + "as profit from transaksi, barang where tanggal_jual = ? "
                + "AND transaksi.id_barang = barang.id) as harga";
        try {
            preparedStatement = conn.prepareStatement(query);
            Calendar cal = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            //preparedStatement.setString(1, df.format(cal.getTime()));
            preparedStatement.setString(1, TRIAL_DATE);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
                DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

                formatRp.setCurrencySymbol("Rp. ");
                formatRp.setMonetaryDecimalSeparator(',');
                formatRp.setGroupingSeparator('.');
                kursIndonesia.setDecimalFormatSymbols(formatRp);
                String profit = kursIndonesia.format(rs.getInt("profit_hari_ini"));
                if (profit.charAt(0) == '(') {
                    profit = profit.substring(1, profit.length() - 1);
                    profit = "- " + profit;
                }

                //System.out.println(profit);
                return profit;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Vector getEmployeeOftheDay() { //QUERY untuk mendapatkan urutan semua employee dari penghasil profit terbesar ke kecil per harinya
        String query = "SELECT nama, SUM(profit) as total\n"
                + "from (SELECT pekerja.nama as nama, (harga_jual - harga_beli) as profit from transaksi, barang, pekerja where tanggal_jual = ? "
                + "AND transaksi.id_barang = barang.id AND transaksi.id_pekerja = pekerja.id) as list_profit \n"
                + "GROUP BY nama ORDER BY total DESC";
        try {
            preparedStatement = conn.prepareStatement(query);
            Calendar cal = Calendar.getInstance();
            DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
            //preparedStatement.setString(1, df.format(cal.getTime()));
            preparedStatement.setString(1, TRIAL_DATE);
            rs = preparedStatement.executeQuery();

            Vector pekerja = new Vector();

            while (rs.next()) {
                pekerja.add(rs.getString("nama"));
            }
            return pekerja;

        } catch (SQLException ex) {
            ex.printStackTrace();;
        }
        return null;
    }

    public static void getEmployeeRankingByProfit() { //Untuk per montoh diganti aja WHERE nya
        String query = "SELECT nama, SUM(profit) as total\n"
                + "from (SELECT pekerja.nama as nama, (harga_jual - harga_beli) as profit from transaksi, barang, pekerja where DAY(tanggal_jual) = 27 AND transaksi.id_barang = barang.id AND transaksi.id_pekerja = pekerja.id) as list_profit \n"
                + "GROUP BY nama ORDER BY total DESC";
    }

    public static int getTotalPenjualan() {
        String query = "SELECT SUM(harga_jual) FROM transaksi WHERE MONTH(tanggal_jual) = ? AND YEAR( tanggal_jual ) = ?;";
        Calendar cal = Calendar.getInstance();
        try {
            preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, cal.get(Calendar.MONTH));
//            preparedStatement.setInt(2, cal.get(Calendar.YEAR));
            preparedStatement.setInt(1, TRIAL_MONTH);
            preparedStatement.setInt(2, TRIAL_YEAR);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {

                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan Total Penjualan");
        }
        return 0;

    }

    public static int getTotalPembelian() {
        String query = "SELECT SUM(harga_beli) FROM barang WHERE MONTH(tanggal_beli) = ? AND YEAR(tanggal_beli) = ? ;";
        Calendar cal = Calendar.getInstance();
        try {
            preparedStatement = conn.prepareStatement(query);
//            preparedStatement.setInt(1, cal.get(Calendar.MONTH));
//            preparedStatement.setInt(2, cal.get(Calendar.YEAR));
            preparedStatement.setInt(1, TRIAL_MONTH);
            preparedStatement.setInt(2, TRIAL_YEAR);
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException ex) {
            System.out.println("Gagal mendapatkan Total Pembelian");
        }
        return 0;

    }
}
