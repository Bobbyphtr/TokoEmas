package popups;

import POJO.KategoriData;
import POJO.Produk;
import POJO.SupplierData;
import customComponents.*;
import static database.Controller.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author Xenon
 */
public class EditProduk extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */
    JDatePickerImpl datePicker;
    Hashtable kategori;
    Hashtable supplier;
    Produk produk;

    public EditProduk(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EditProduk(Produk produkOper) {
        this.produk = produkOper;
        initComponents();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(produk.getTanggalBeli());
        initDatePicker(calendar);
        initHashtable();

        for (int i = 0; i < spinnerStatus.getModel().getSize(); i++) {
            if (produk.getStatus().equalsIgnoreCase(spinnerStatus.getModel().getElementAt(i))) {
                spinnerStatus.setSelectedIndex(i);
                break;
            }
        }
        fieldNamaProduk.setText(produk.getNama());
        fieldNamaProduk.setForeground(Color.BLACK);
        textAreaDeskripsiProduk.setText(produk.getDeskripsi());
        textAreaDeskripsiProduk.setForeground(Color.BLACK);
        spinnerBerat.getModel().setValue(produk.getBerat());

        for (int i = 0; i < comboKarat.getModel().getSize(); i++) {
            if (String.valueOf(produk.getKarat()).equals(comboKarat.getModel().getElementAt(i))) {
                comboKarat.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < spinnerKategori.getModel().getSize(); i++) {
            if (String.valueOf(produk.getKategori()).equals(spinnerKategori.getModel().getElementAt(i))) {
                spinnerKategori.setSelectedIndex(i);
                break;
            }
        }

        for (int i = 0; i < spinnerSupplier.getModel().getSize(); i++) {
            if (String.valueOf(produk.getSupplier()).equals(spinnerSupplier.getModel().getElementAt(i))) {
                spinnerSupplier.setSelectedIndex(i);
                break;
            }
        }

        //Combo box listener
        comboKarat.addItemListener((ItemEvent ie) -> {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                if (ie.getItem().equals("-- Tambah Karat --")) {
                    try {
                        int karatBaru = Integer.valueOf(JOptionPane.showInputDialog("Input karat :"));
                        if (karatBaru != 0) {
                            addKarat(karatBaru);
                            comboKarat.setModel(getKarat());
                            comboKarat.setSelectedItem(karatBaru);
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Silahkan input angka", "Perhatian", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

    }

    private void initDatePicker(Calendar calendar) {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.getModel().setDay(calendar.get(Calendar.DATE));
        datePicker.getModel().setMonth(calendar.get(Calendar.MONTH));
        datePicker.getModel().setYear(calendar.get(Calendar.YEAR));
        datePicker.getModel().setSelected(true);
        dateContainer2.setLayout(new BorderLayout());
        dateContainer2.add(datePicker);
        this.setFocusable(true);
    }

    private void initHashtable() {
        supplier = new Hashtable();
        Vector supplierV = getAllSupplier();
        for (Object object : supplierV) {
            SupplierData temp = (SupplierData) object;
            supplier.put(temp.getNama(), temp.getId());
        }

        kategori = new Hashtable();
        Vector kategoriV = getKategori();
        for (Object object : kategoriV) {
            KategoriData temp = (KategoriData) object;
            kategori.put(temp.getNama(), temp.getId());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TambahPelangganPanel = new javax.swing.JPanel();
        TitleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        fieldNamaProduk = new javax.swing.JTextField();
        fieldNamaProduk = new CorneredJTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaDeskripsiProduk = new javax.swing.JTextArea();
        textAreaDeskripsiProduk = new CorneredJTextArea();
        simpanButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        spinnerBerat = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        spinnerSupplier = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        spinnerKategori = new javax.swing.JComboBox<>();
        spinnerStatus = new javax.swing.JComboBox<>();
        dateContainer2 = new javax.swing.JPanel();
        comboKarat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Edit Produk");

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Tanggal Beli");

        fieldNamaProduk.setForeground(java.awt.Color.gray);
        fieldNamaProduk.setText("Masukan nama produk.");

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Nama Produk");

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Deskripsi Produk");

        textAreaDeskripsiProduk.setColumns(20);
        textAreaDeskripsiProduk.setForeground(java.awt.Color.gray);
        textAreaDeskripsiProduk.setRows(5);
        textAreaDeskripsiProduk.setText("Masukan alamat.");
        textAreaDeskripsiProduk.setBorder(null);
        jScrollPane1.setViewportView(textAreaDeskripsiProduk);
        jScrollPane1.setBorder(null);

        simpanButton.setBackground(new java.awt.Color(89, 38, 1));
        simpanButton.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        simpanButton.setForeground(java.awt.Color.white);
        simpanButton.setText("Simpan");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Berat:");

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Karat:");

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("gram");

        jLabel8.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Kategori:");

        spinnerSupplier.setModel(getSupplierComboBoxModel());
        spinnerSupplier.addItem("Tidak ada supplier/dihapus");

        jLabel9.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 0, 0));
        jLabel9.setText("Supplier:");

        spinnerKategori.setModel(getKategoriComboBoxModel());
        spinnerKategori.addItem("Tidak ada kategori");

        spinnerStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--status--", "INSTOCK", "SOLD", "MISSING" }));

        javax.swing.GroupLayout dateContainer2Layout = new javax.swing.GroupLayout(dateContainer2);
        dateContainer2.setLayout(dateContainer2Layout);
        dateContainer2Layout.setHorizontalGroup(
            dateContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        dateContainer2Layout.setVerticalGroup(
            dateContainer2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        comboKarat.setModel(getKarat());
        comboKarat.addItem("-- Tambah Karat --");

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6))
                            .addGap(11, 11, 11)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                                    .addComponent(spinnerBerat, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel7))
                                .addComponent(comboKarat, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(59, 59, 59)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(spinnerSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(spinnerKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(dateContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                            .addComponent(TitleText)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(spinnerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        TambahPelangganPanelLayout.setVerticalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spinnerStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addComponent(TitleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dateContainer2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNamaProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(spinnerBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(spinnerKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9)
                    .addComponent(spinnerSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboKarat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        produk.setStatus((String) spinnerStatus.getSelectedItem());

        java.util.Date foundDateUtil = (java.util.Date) datePicker.getModel().getValue();
        Instant instant = foundDateUtil.toInstant();
        ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
        LocalDate foundDate = zdt.toLocalDate();
        produk.setTanggalBeli(Date.valueOf(foundDate));

        produk.setNama(fieldNamaProduk.getText());
        produk.setDeskripsi(textAreaDeskripsiProduk.getText());
        produk.setBerat((double) spinnerBerat.getValue());
        produk.setKarat((int) comboKarat.getSelectedItem());
        if (!spinnerKategori.getSelectedItem().equals("Tidak ada kategori")) {
            produk.setIdKategori((int) kategori.get(spinnerKategori.getSelectedItem()));
        } else {
            produk.setIdKategori(0);
        }
        if (!spinnerSupplier.getSelectedItem().equals("Tidak ada supplier/dihapus")) {
            produk.setIdSupplier((int) supplier.get(spinnerSupplier.getSelectedItem()));
        } else {
            produk.setIdSupplier(0);
        }
        
        
        updateProduk(produk);
    }//GEN-LAST:event_simpanButtonActionPerformed

    public static void main(String args[]) {
        JFrame a = new JFrame();

        //EditProduk dialog = new EditProduk(a, true);
        //a.setPreferredSize(dialog.getPreferredSize());
        //dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText;
    private javax.swing.JComboBox<String> comboKarat;
    private javax.swing.JPanel dateContainer2;
    private javax.swing.JTextField fieldNamaProduk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpanButton;
    private javax.swing.JSpinner spinnerBerat;
    private javax.swing.JComboBox<String> spinnerKategori;
    private javax.swing.JComboBox<String> spinnerStatus;
    private javax.swing.JComboBox<String> spinnerSupplier;
    private javax.swing.JTextArea textAreaDeskripsiProduk;
    // End of variables declaration//GEN-END:variables
}
