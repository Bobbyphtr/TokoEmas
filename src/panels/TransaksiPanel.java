package panels;

/**
 *
 * @author Xenon
 */
import CustomJTables.*;
import POJO.Produk;
import POJO.Transaksi;
import customComponents.*;
import database.Controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.Properties;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import popups.*;

import static database.Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

public class TransaksiPanel extends javax.swing.JPanel {

    /**
     * Creates new form Staff
     */
    JDatePickerImpl datePicker;

    DefaultTableModel troliModel;
    DefaultTableModel produkModel;

    ButtonGroup group;
    
    int idPelanggan;
    int idStaff;
    
    TransaksiPanel transaksiPanel;

    public TransaksiPanel() {
        transaksiPanel = this;
        
        
        initTableModel();
        initComponents();
        initDatePicker();
        initRadioButton();
        syncDate();

        removeTableProdukTroliColumn();
        removeTableTroliColumn();

        tableProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                infoProdukController(tableProduk.convertRowIndexToModel(tableProduk.getSelectedRow()));
            }
        });

        tableTroli.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                infoTroliController(tableTroli.convertRowIndexToModel(tableTroli.getSelectedRow()));
            }
        });

        troliModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                totalBiaya();
            }
        });
    }
    
    public void setIdPelanggan(int id) {
        idPelanggan = id;
    }
    
    public void setIdStaff(int id) {
        idStaff = id;
    }

    private void reset() {
        
    }

    private void initRadioButton() {
        group = new ButtonGroup();
        group.add(radioCash);
        group.add(radioCredit);
        group.add(radioDebit);
    }

    private void removeTableTroliColumn() {

        TableColumn id = tableTroli.getColumnModel().getColumn(0);
        TableColumn deskripsi = tableTroli.getColumnModel().getColumn(2);
        TableColumn supplier = tableTroli.getColumnModel().getColumn(7);
        TableColumn hargaBeli = tableTroli.getColumnModel().getColumn(8);
        TableColumn tglBeli = tableTroli.getColumnModel().getColumn(9);

        tableTroli.getColumnModel().removeColumn(id);
        tableTroli.getColumnModel().removeColumn(deskripsi);
        tableTroli.getColumnModel().removeColumn(supplier);
        tableTroli.getColumnModel().removeColumn(tglBeli);
        tableTroli.getColumnModel().removeColumn(hargaBeli);
    }

    private void removeTableProdukTroliColumn() {

        TableColumn id = tableProduk.getColumnModel().getColumn(0);
        TableColumn deskripsi = tableProduk.getColumnModel().getColumn(2);
        TableColumn supplier = tableProduk.getColumnModel().getColumn(7);
        TableColumn tglBeli = tableProduk.getColumnModel().getColumn(9);

        tableProduk.getColumnModel().removeColumn(id);
        tableProduk.getColumnModel().removeColumn(deskripsi);
        tableProduk.getColumnModel().removeColumn(supplier);
        tableProduk.getColumnModel().removeColumn(tglBeli);

    }

    private void initDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        dateContainer.setLayout(new BorderLayout());
        dateContainer.add(datePicker);
        this.setFocusable(true);
    }

    private void initTableModel() {
        produkModel = getAllProduk();
        troliModel = new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "ID", "Nama", "Deskripsi", "Berat", "Karat", "Tipe", "Kategori", "Supplier", "Harga Beli", "Tanggal Beli", "Harga Jual", "Aksi"
                }
        );
    }

    private void syncDate() {
        String[] dateAndTime = getDateAndTime();
        timeText.setText(dateAndTime[0]);
        dateText.setText(dateAndTime[1]);
        System.out.println(dateAndTime[1]);
        Timer date = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dateAndTime = getDateAndTime();
                timeText.setText(dateAndTime[0]);
                dateText.setText(dateAndTime[1]);
            }
        });
        date.start();
    }

    private void infoProdukController(int rowIdx) {
        if (rowIdx > -1) {
            labelNama.setText((String) tableProduk.getModel().getValueAt(rowIdx, 1));
            labelDeskripsi.setText((String) tableProduk.getModel().getValueAt(rowIdx, 2));
            labelWeight.setText(String.valueOf((Double) tableProduk.getModel().getValueAt(rowIdx, 3)));
            labelKarat.setText(String.valueOf((Double) tableProduk.getModel().getValueAt(rowIdx, 4)));
            labelType.setText((String) tableProduk.getModel().getValueAt(rowIdx, 5));
            labelKategori.setText((String) tableProduk.getModel().getValueAt(rowIdx, 6));
            labelSupplier.setText((String) tableProduk.getModel().getValueAt(rowIdx, 7));
            textHargaBeli.setText("Harga Beli");
            labelHargaBeli.setText(intToCurrency((Integer) tableProduk.getModel().getValueAt(rowIdx, 8)));
        } else {
            labelNama.setText("-");
            labelDeskripsi.setText("-");
            labelWeight.setText("-");
            labelKarat.setText("-");
            labelType.setText("-");
            labelKategori.setText("-");
            labelSupplier.setText("-");
            textHargaBeli.setText("Harga Beli");
            labelHargaBeli.setText("-");
        }

    }

    private void infoTroliController(int rowIdx) {
        if (rowIdx > -1) {
            System.out.println("Row Index = " + rowIdx);
            labelNama.setText((String) tableTroli.getModel().getValueAt(rowIdx, 1));
            labelDeskripsi.setText((String) tableTroli.getModel().getValueAt(rowIdx, 2));
            labelWeight.setText(String.valueOf((Double) tableTroli.getModel().getValueAt(rowIdx, 3)));
            labelKarat.setText(String.valueOf((Double) tableTroli.getModel().getValueAt(rowIdx, 4)));
            labelType.setText((String) tableTroli.getModel().getValueAt(rowIdx, 5));
            labelKategori.setText((String) tableTroli.getModel().getValueAt(rowIdx, 6));
            labelSupplier.setText((String) tableTroli.getModel().getValueAt(rowIdx, 7));
            textHargaBeli.setText("Harga Jual");
            labelHargaBeli.setText(intToCurrency((Integer) tableTroli.getModel().getValueAt(rowIdx, 10)));
        } else {
            labelNama.setText("-");
            labelDeskripsi.setText("-");
            labelWeight.setText("-");
            labelKarat.setText("-");
            labelType.setText("-");
            labelKategori.setText("-");
            labelSupplier.setText("-");
            textHargaBeli.setText("Harga Jual");
            labelHargaBeli.setText("-");
        }

    }

    private String intToCurrency(int number) {
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        return kursIndonesia.format(number);

    }

    private void totalBiaya() {
        
        int total = 0;
        for (int i = 0; i < tableTroli.getModel().getRowCount(); i++) {
            total += (Integer) tableTroli.getModel().getValueAt(i, 10);
        }

        labelHargaTotal.setText(intToCurrency(total));
    }
    
    private void tambahTransaksi() {
        for (int i = 0; i < tableTroli.getModel().getRowCount(); i++) {
            int idBarang = (Integer) tableTroli.getModel().getValueAt(i, 0);
            int idCustomer = idPelanggan;
            int idPekerja  = idStaff;
            String metodePembayaran = getSelectedButtonText();
            int hargaJual = (Integer) tableTroli.getModel().getValueAt(i, 10);
            Date tanggalJual = getDate();
            Transaksi transaksi = new Transaksi(idBarang, idCustomer, idPekerja, metodePembayaran, hargaJual, tanggalJual);
            addTransaksi(transaksi);
        }
    }

    public String getSelectedButtonText() {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }

    public Date getDate() {
        java.util.Date foundDateUtil = (java.util.Date) datePicker.getModel().getValue();
        if (foundDateUtil != null) {
            Instant instant = foundDateUtil.toInstant();
            ZoneId zoneId = ZoneId.of("Asia/Ho_Chi_Minh");
            ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, zoneId);
            LocalDate foundDate = zdt.toLocalDate();

            Date tanggalBeli = Date.valueOf(foundDate);

            return tanggalBeli;
        }
        return null;
    }

    public void updateStatusBarang() {
        for (int i = 0; i < tableTroli.getModel().getRowCount(); i++) {
            int id = (Integer) tableTroli.getModel().getValueAt(i, 0);
            System.out.println("ID = " + id);
            updateStatusProduk(id);
            reset();
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        TitleText = new javax.swing.JLabel();
        buttonTambah = new javax.swing.JButton();
        fieldCariProduk = new javax.swing.JTextField();
        fieldCariProduk = new CorneredJTextField();
        jlabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();
        timeText = new javax.swing.JLabel();
        jlabel1 = new javax.swing.JLabel();
        jlabel2 = new javax.swing.JLabel();
        labelNamaStaff = new javax.swing.JLabel();
        LabelNamaPelanggan = new javax.swing.JLabel();
        buttonPilihStaf = new javax.swing.JButton();
        buttonPilihPelanggan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduk = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableTroli = new javax.swing.JTable();
        TitleText1 = new javax.swing.JLabel();
        jlabel3 = new javax.swing.JLabel();
        TitleText2 = new javax.swing.JLabel();
        jlabel4 = new javax.swing.JLabel();
        fieldCariTroli = new javax.swing.JTextField();
        fieldCariTroli = new CorneredJTextField();
        labelHargaTotal = new javax.swing.JLabel();
        jlabel6 = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        radioCredit = new javax.swing.JRadioButton();
        radioDebit = new javax.swing.JRadioButton();
        radioCash = new javax.swing.JRadioButton();
        panelInfoProduk = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelDeskripsi = new javax.swing.JLabel();
        labelWeight = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelKarat = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        labelType = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        labelKategori = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        labelSupplier = new javax.swing.JLabel();
        textHargaBeli = new javax.swing.JLabel();
        labelHargaBeli = new javax.swing.JLabel();
        jlabel8 = new javax.swing.JLabel();
        dateContainer = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setBackground(new java.awt.Color(255, 231, 192));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(980, 720));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Transaksi");
        add(TitleText, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        buttonTambah.setBackground(new java.awt.Color(89, 38, 1));
        buttonTambah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonTambah.setForeground(java.awt.Color.white);
        buttonTambah.setText("Tambah Transaksi");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });
        add(buttonTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 630, -1, 37));

        fieldCariProduk.setForeground(java.awt.Color.gray);
        fieldCariProduk.setText("Ketik pencarian");
        fieldCariProduk.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCariProdukFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCariProdukFocusLost(evt);
            }
        });
        add(fieldCariProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 191, 30));

        jlabel.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel.setForeground(new java.awt.Color(102, 0, 0));
        jlabel.setText("Pilih Tanggal Transaksi");
        add(jlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(934, 0, -1, 720));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        dateText.setBackground(new java.awt.Color(102, 0, 0));
        dateText.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        dateText.setForeground(new java.awt.Color(102, 0, 0));
        dateText.setText("<DD-MM-YYYY>");
        add(dateText, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, -1, -1));

        timeText.setBackground(new java.awt.Color(102, 0, 0));
        timeText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        timeText.setForeground(new java.awt.Color(102, 0, 0));
        timeText.setText("<TIME>");
        add(timeText, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 20, -1, -1));

        jlabel1.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(102, 0, 0));
        jlabel1.setText("Cari");
        add(jlabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 70, -1, -1));

        jlabel2.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel2.setForeground(new java.awt.Color(102, 0, 0));
        jlabel2.setText("Pelanggan");
        add(jlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        labelNamaStaff.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelNamaStaff.setForeground(new java.awt.Color(102, 0, 0));
        labelNamaStaff.setText("<Nama>");
        add(labelNamaStaff, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        LabelNamaPelanggan.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        LabelNamaPelanggan.setForeground(new java.awt.Color(102, 0, 0));
        LabelNamaPelanggan.setText("Default");
        add(LabelNamaPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        buttonPilihStaf.setBackground(new java.awt.Color(89, 38, 1));
        buttonPilihStaf.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonPilihStaf.setForeground(java.awt.Color.white);
        buttonPilihStaf.setText("Pilih Staf");
        buttonPilihStaf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPilihStafActionPerformed(evt);
            }
        });
        add(buttonPilihStaf, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 120, 37));

        buttonPilihPelanggan.setBackground(new java.awt.Color(89, 38, 1));
        buttonPilihPelanggan.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonPilihPelanggan.setForeground(java.awt.Color.white);
        buttonPilihPelanggan.setText("Pilih Pelanggan");
        buttonPilihPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPilihPelangganActionPerformed(evt);
            }
        });
        add(buttonPilihPelanggan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, 37));

        tableProduk.setModel(produkModel);
        tableProduk.setDefaultRenderer(Object.class, new ObjectTableCellRenderer());
        tableProduk.setDefaultRenderer(Integer.class, new IntegerTableCellRenderer());
        tableProduk.setDefaultRenderer(Double.class, new DoubleTableCellRenderer());

        tableProduk.getColumn("Aksi").setCellEditor(new CustomTableCell.TransaksiProdukCell(new JCheckBox(), produkModel, troliModel));
        tableProduk.getColumn("Aksi").setCellRenderer(new CustomTableCell.TransaksiProdukCell(new JCheckBox(), produkModel, troliModel));

        tableProduk.setColumnSelectionAllowed(false);
        jScrollPane1.setViewportView(tableProduk);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 100, 510, 150));

        tableTroli.setModel(troliModel);
        tableTroli.setDefaultRenderer(Object.class, new ObjectTableCellRenderer());
        tableTroli.setDefaultRenderer(Integer.class, new IntegerTableCellRenderer());
        tableTroli.setDefaultRenderer(Double.class, new DoubleTableCellRenderer());

        tableTroli.getColumn("Aksi").setCellEditor(new CustomTableCell.TransaksiTroliCell(new JCheckBox(), produkModel, troliModel));
        tableTroli.getColumn("Aksi").setCellRenderer(new CustomTableCell.TransaksiTroliCell(new JCheckBox(), produkModel, troliModel));
        jScrollPane2.setViewportView(tableTroli);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 350, 510, 150));

        TitleText1.setBackground(new java.awt.Color(102, 0, 0));
        TitleText1.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText1.setForeground(new java.awt.Color(102, 0, 0));
        TitleText1.setText("Troli");
        add(TitleText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, -1, -1));

        jlabel3.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel3.setForeground(new java.awt.Color(102, 0, 0));
        jlabel3.setText("Staff");
        add(jlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        TitleText2.setBackground(new java.awt.Color(102, 0, 0));
        TitleText2.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText2.setForeground(new java.awt.Color(102, 0, 0));
        TitleText2.setText("Produk");
        add(TitleText2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, -1, -1));

        jlabel4.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel4.setForeground(new java.awt.Color(102, 0, 0));
        jlabel4.setText("Cari");
        add(jlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));

        fieldCariTroli.setForeground(java.awt.Color.gray);
        fieldCariTroli.setText("Ketik pencarian");
        fieldCariTroli.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCariTroliFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCariTroliFocusLost(evt);
            }
        });
        add(fieldCariTroli, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 310, 191, 30));

        labelHargaTotal.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelHargaTotal.setForeground(new java.awt.Color(102, 0, 0));
        labelHargaTotal.setText("<HargaTotal>");
        add(labelHargaTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 513, -1, -1));

        jlabel6.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel6.setForeground(new java.awt.Color(102, 0, 0));
        jlabel6.setText("Total : ");
        add(jlabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(695, 513, -1, -1));

        jlabel7.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel7.setForeground(new java.awt.Color(102, 0, 0));
        jlabel7.setText("Metode Bayar");
        add(jlabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, -1, -1));

        radioCredit.setText("Credit");
        add(radioCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, -1, -1));

        radioDebit.setText("Debit");
        add(radioDebit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, -1, -1));

        radioCash.setText("Cash");
        add(radioCash, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 570, -1, -1));

        panelInfoProduk.setBackground(java.awt.Color.white);
        panelInfoProduk.setBorder(new BubbleBorderJPanel(Color.WHITE, 10, 20, 0));
        panelInfoProduk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel1.setForeground(java.awt.Color.gray);
        jLabel1.setText("Deskripsi:");
        panelInfoProduk.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        labelDeskripsi.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelDeskripsi.setForeground(java.awt.Color.black);
        labelDeskripsi.setText("Deskripsi");
        panelInfoProduk.add(labelDeskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        labelWeight.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelWeight.setForeground(java.awt.Color.black);
        labelWeight.setText("Weight");
        panelInfoProduk.add(labelWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        labelNama.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelNama.setForeground(java.awt.Color.black);
        labelNama.setText("Nama");
        panelInfoProduk.add(labelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabel10.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel10.setForeground(java.awt.Color.gray);
        jLabel10.setText("Weight:");
        panelInfoProduk.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel11.setForeground(java.awt.Color.gray);
        jLabel11.setText("Karat:");
        panelInfoProduk.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        labelKarat.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelKarat.setForeground(java.awt.Color.black);
        labelKarat.setText("Karat");
        panelInfoProduk.add(labelKarat, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel13.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel13.setForeground(java.awt.Color.gray);
        jLabel13.setText("Type:");
        panelInfoProduk.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        labelType.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelType.setForeground(java.awt.Color.black);
        labelType.setText("Type");
        panelInfoProduk.add(labelType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel15.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel15.setForeground(java.awt.Color.gray);
        jLabel15.setText("Kategori:");
        panelInfoProduk.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        labelKategori.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelKategori.setForeground(java.awt.Color.black);
        labelKategori.setText("Kategori");
        panelInfoProduk.add(labelKategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel17.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel17.setForeground(java.awt.Color.gray);
        jLabel17.setText("Supplier:");
        panelInfoProduk.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

        labelSupplier.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelSupplier.setForeground(java.awt.Color.black);
        labelSupplier.setText("Supplier");
        panelInfoProduk.add(labelSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        textHargaBeli.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        textHargaBeli.setForeground(java.awt.Color.gray);
        textHargaBeli.setText("Harga Beli:");
        panelInfoProduk.add(textHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        labelHargaBeli.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelHargaBeli.setForeground(java.awt.Color.black);
        labelHargaBeli.setText("Harga Beli");
        panelInfoProduk.add(labelHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        add(panelInfoProduk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 300, 320, 350));

        jlabel8.setFont(new java.awt.Font("Myriad Pro", 0, 28)); // NOI18N
        jlabel8.setForeground(new java.awt.Color(102, 0, 0));
        jlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_Information_50px_4.png"))); // NOI18N
        jlabel8.setText("Info Produk");
        add(jlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        javax.swing.GroupLayout dateContainerLayout = new javax.swing.GroupLayout(dateContainer);
        dateContainer.setLayout(dateContainerLayout);
        dateContainerLayout.setHorizontalGroup(
            dateContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        dateContainerLayout.setVerticalGroup(
            dateContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        add(dateContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 320, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void fieldCariProdukFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariProdukFocusGained
        if (fieldCariProduk.getText().equals("Ketik pencarian")) {
            fieldCariProduk.setText("");
            fieldCariProduk.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldCariProdukFocusGained

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        boolean check = true;

        if (getDate() == null) {
            check = false;
            JOptionPane.showMessageDialog(this, "Tanggal Transaksi belum dipilih.");
        } else if (labelNamaStaff.getText().equalsIgnoreCase("<Nama>")) {
            check = false;
            JOptionPane.showMessageDialog(this, "Nama Staff belum dipilih.");
        } else if (tableTroli.getModel().getRowCount() == 0) {
            check = false;
            JOptionPane.showMessageDialog(this, "Tidak ada produk pada Troli.");
        } else if (getSelectedButtonText() == null) {
            check = false;
            JOptionPane.showMessageDialog(this, "Jenis Transaksi belum dipilih.");
        }

        if (check) {
            updateStatusBarang();
            tambahTransaksi();
            System.out.println(idStaff);
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void fieldCariProdukFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariProdukFocusLost
        if (fieldCariProduk.getText().equals("")) {
            fieldCariProduk.setText("Ketik pencarian");
            fieldCariProduk.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldCariProdukFocusLost

    private void buttonPilihStafActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPilihStafActionPerformed
        JDialog pilihStafDialog = new JDialog();
        pilihStafDialog.setContentPane(new PilihStaf(labelNamaStaff, transaksiPanel));
        pilihStafDialog.pack();
        pilihStafDialog.setLocationRelativeTo(this);
        pilihStafDialog.setVisible(true);
        pilihStafDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Clossed!");
            }
        });
    }//GEN-LAST:event_buttonPilihStafActionPerformed

    private void buttonPilihPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPilihPelangganActionPerformed
        JDialog pilihPelangganDialog = new JDialog();
        pilihPelangganDialog.setContentPane(new PilihPelanggan(LabelNamaPelanggan, transaksiPanel));
        pilihPelangganDialog.pack();
        pilihPelangganDialog.setVisible(true);
    }//GEN-LAST:event_buttonPilihPelangganActionPerformed

    private void fieldCariTroliFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariTroliFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariTroliFocusGained

    private void fieldCariTroliFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariTroliFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariTroliFocusLost

    public static void main(String args[]) {
        Controller con = new Controller();
        JFrame a = new JFrame();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TransaksiPanel panel = new TransaksiPanel();
        a.setSize(panel.getPreferredSize());
        a.setContentPane(panel);
        a.setVisible(true);
        System.out.println("Width : " + a.getWidth());
        System.out.println("Height : " + a.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelNamaPelanggan;
    private javax.swing.JLabel TitleText;
    private javax.swing.JLabel TitleText1;
    private javax.swing.JLabel TitleText2;
    private javax.swing.JButton buttonPilihPelanggan;
    private javax.swing.JButton buttonPilihStaf;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JPanel dateContainer;
    private javax.swing.JLabel dateText;
    private javax.swing.JTextField fieldCariProduk;
    private javax.swing.JTextField fieldCariTroli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel jlabel2;
    private javax.swing.JLabel jlabel3;
    private javax.swing.JLabel jlabel4;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JLabel jlabel8;
    private javax.swing.JLabel labelDeskripsi;
    private javax.swing.JLabel labelHargaBeli;
    private javax.swing.JLabel labelHargaTotal;
    private javax.swing.JLabel labelKarat;
    private javax.swing.JLabel labelKategori;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNamaStaff;
    private javax.swing.JLabel labelSupplier;
    private javax.swing.JLabel labelType;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JPanel panelInfoProduk;
    private javax.swing.JRadioButton radioCash;
    private javax.swing.JRadioButton radioCredit;
    private javax.swing.JRadioButton radioDebit;
    private javax.swing.JTable tableProduk;
    private javax.swing.JTable tableTroli;
    private javax.swing.JLabel textHargaBeli;
    private javax.swing.JLabel timeText;
    // End of variables declaration//GEN-END:variables

}
