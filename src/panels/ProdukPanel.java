package panels;

/**
 *
 * @author Xenon
 */
import customComponents.*;
import CustomJTables.*;
import POJO.Produk;
import database.Controller;
import static database.Controller.getAllProdukPanel;
import static database.Controller.getDateAndTime;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
import popups.EditProduk;
import popups.Kategori;
import popups.Supplier;
import popups.TambahProduk;

public class ProdukPanel extends javax.swing.JPanel {

    /**
     * Creates new form Staff
     */
    TableModel produkModel;
    TableColumn deskripsi, berat, karat, tipeBarang, idKategori, idSupplier;
    TableRowSorter<TableModel> rowFilter;

    public ProdukPanel() {
        initComponents();
        initModel();
        syncDate();
        setUpRowFilter();
        buttonUbah.setEnabled(false);
    }

    private void initModel() {
        produkModel = tableProduk.getModel();
        //hide column
        deskripsi = tableProduk.getColumnModel().getColumn(2);
        berat = tableProduk.getColumnModel().getColumn(3);
        karat = tableProduk.getColumnModel().getColumn(4);
        tipeBarang = tableProduk.getColumnModel().getColumn(6);
        idKategori = tableProduk.getColumnModel().getColumn(7);
        idSupplier = tableProduk.getColumnModel().getColumn(8);

        tableProduk.getColumnModel().removeColumn(deskripsi);
        tableProduk.getColumnModel().removeColumn(berat);
        tableProduk.getColumnModel().removeColumn(karat);
        tableProduk.getColumnModel().removeColumn(tipeBarang);
        tableProduk.getColumnModel().removeColumn(idKategori);
        tableProduk.getColumnModel().removeColumn(idSupplier);

        tableProduk.getColumnModel().moveColumn(4, 0);
        tableProduk.getColumnModel().moveColumn(3, 4);
    }

    private void setUpRowFilter() {
        rowFilter = new TableRowSorter<>(tableProduk.getModel());
        tableProduk.setRowSorter(rowFilter);
        fieldCari.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent de) {
                String text = fieldCari.getText();
                if (!text.equalsIgnoreCase("Ketik pencarian")) {
                    if (text.trim().length() == 0) {
                        rowFilter.setRowFilter(null);
                    } else {
                        rowFilter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }

            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                String text = fieldCari.getText();
                if (!text.equalsIgnoreCase("Ketik pencarian")) {
                    if (text.trim().length() == 0) {
                        rowFilter.setRowFilter(null);
                    } else {
                        rowFilter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                    }
                }
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

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

        tableProduk.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    if (tableProduk.getSelectedRow() > -1) {
                        infoProdukController(tableProduk.convertRowIndexToModel(tableProduk.getSelectedRow()));
                        buttonUbah.setEnabled(true);
                    }
                }
            }
        });
    }

    private void infoProdukController(int rowIdx) {
        if (rowIdx > -1) {
            labelNama.setText((String) tableProduk.getModel().getValueAt(rowIdx, 1));
            labelDeskripsi.setText((String) tableProduk.getModel().getValueAt(rowIdx, 2));
            labelWeight.setText(String.valueOf((Double) tableProduk.getModel().getValueAt(rowIdx, 3)));
            labelKarat.setText(String.valueOf((Double) tableProduk.getModel().getValueAt(rowIdx, 4)));
            labelType.setText((String) tableProduk.getModel().getValueAt(rowIdx, 6));
            labelKategori.setText((String) tableProduk.getModel().getValueAt(rowIdx, 7));
            labelSupplier.setText((String) tableProduk.getModel().getValueAt(rowIdx, 8));
            labelHargaBeli.setText(intToCurrency((Integer) tableProduk.getModel().getValueAt(rowIdx, 9)));
        } else {
            labelNama.setText("-");
            labelDeskripsi.setText("-");
            labelWeight.setText("-");
            labelKarat.setText("-");
            labelType.setText("-");
            labelKategori.setText("-");
            labelSupplier.setText("-");
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        TitleText = new javax.swing.JLabel();
        buttonSupplier = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduk = new javax.swing.JTable();
        fieldCari = new javax.swing.JTextField();
        fieldCari = new CorneredJTextField();
        jlabel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        dateText = new javax.swing.JLabel();
        timeText = new javax.swing.JLabel();
        buttonKategori = new javax.swing.JButton();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        jlabel1 = new javax.swing.JLabel();
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
        jLabel19 = new javax.swing.JLabel();
        labelHargaBeli = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(255, 231, 192));
        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(980, 720));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Produk");

        buttonSupplier.setBackground(new java.awt.Color(126, 80, 23));
        buttonSupplier.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonSupplier.setForeground(java.awt.Color.white);
        buttonSupplier.setText("Supplier");
        buttonSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSupplierActionPerformed(evt);
            }
        });

        tableProduk.setModel(getAllProdukPanel());
        tableProduk.setRowSelectionAllowed(true);
        tableProduk.setColumnSelectionAllowed(false);

        tableProduk.setDefaultRenderer(Object.class, new ObjectTableCellRenderer());
        tableProduk.setDefaultRenderer(Integer.class, new IntegerTableCellRenderer());
        tableProduk.setDefaultRenderer(Double.class, new DoubleTableCellRenderer());
        jScrollPane1.setViewportView(tableProduk);

        fieldCari.setForeground(java.awt.Color.gray);
        fieldCari.setText("Ketik pencarian");
        fieldCari.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldCariFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldCariFocusLost(evt);
            }
        });
        fieldCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldCariActionPerformed(evt);
            }
        });

        jlabel.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jlabel.setForeground(new java.awt.Color(102, 0, 0));
        jlabel.setText("Cari");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        dateText.setBackground(new java.awt.Color(102, 0, 0));
        dateText.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        dateText.setForeground(new java.awt.Color(102, 0, 0));
        dateText.setText("<DD-MM-YYYY>");

        timeText.setBackground(new java.awt.Color(102, 0, 0));
        timeText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        timeText.setForeground(new java.awt.Color(102, 0, 0));
        timeText.setText("<TIME>");

        buttonKategori.setBackground(new java.awt.Color(126, 80, 23));
        buttonKategori.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonKategori.setForeground(java.awt.Color.white);
        buttonKategori.setText("Kategori");
        buttonKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonKategoriActionPerformed(evt);
            }
        });

        buttonTambah.setBackground(new java.awt.Color(89, 38, 1));
        buttonTambah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonTambah.setForeground(java.awt.Color.white);
        buttonTambah.setText("Tambah Produk");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonUbah.setBackground(new java.awt.Color(89, 38, 1));
        buttonUbah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonUbah.setForeground(java.awt.Color.white);
        buttonUbah.setText("Ubah Produk");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        jlabel1.setFont(new java.awt.Font("Myriad Pro", 0, 28)); // NOI18N
        jlabel1.setForeground(new java.awt.Color(102, 0, 0));
        jlabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8_Information_50px_4.png"))); // NOI18N
        jlabel1.setText("Info Produk");

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

        jLabel19.setFont(new java.awt.Font("Myriad Pro", 0, 12)); // NOI18N
        jLabel19.setForeground(java.awt.Color.gray);
        jLabel19.setText("Harga Beli:");
        panelInfoProduk.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        labelHargaBeli.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        labelHargaBeli.setForeground(java.awt.Color.black);
        labelHargaBeli.setText("Harga Beli");
        panelInfoProduk.add(labelHargaBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(buttonTambah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonKategori, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addComponent(buttonUbah, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(486, 486, 486)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(dateText))
                            .addComponent(timeText))
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelInfoProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabel)
                                .addGap(15, 15, 15)
                                .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleText)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(timeText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateText)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlabel)
                            .addComponent(fieldCari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jlabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelInfoProduk, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    private void fieldCariFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariFocusGained
        if (fieldCari.getText().equals("Ketik pencarian")) {
            fieldCari.setText("");
            fieldCari.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldCariFocusGained

    private void buttonSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSupplierActionPerformed
        JDialog supplier = new Supplier();
        supplier.setLocationRelativeTo(this);
        supplier.setVisible(true);
        supplier.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                tableProduk.setModel(getAllProdukPanel());
                produkModel = tableProduk.getModel();
                setUpRowFilter();
                initModel();
            }

        });
    }//GEN-LAST:event_buttonSupplierActionPerformed

    private void fieldCariFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldCariFocusLost
        if (fieldCari.getText().equals("")) {
            fieldCari.setText("Ketik pencarian");
            fieldCari.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldCariFocusLost

    private void fieldCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCariActionPerformed

    private void buttonKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonKategoriActionPerformed
        JDialog kategori = new Kategori();
        kategori.setLocationRelativeTo(this);
        kategori.setVisible(true);
        kategori.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                tableProduk.setModel(getAllProdukPanel());
                produkModel = tableProduk.getModel();
                setUpRowFilter();
                initModel();
            }
        });
    }//GEN-LAST:event_buttonKategoriActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        JDialog tambahProduk = new TambahProduk();
        tambahProduk.setLocationRelativeTo(this);
        tambahProduk.setVisible(true);
        tambahProduk.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
                tableProduk.setModel(getAllProdukPanel());
                produkModel = tableProduk.getModel();
                setUpRowFilter();
                initModel();
            }

        });
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        if (tableProduk.getSelectedColumn() > -1) {
            int idx = tableProduk.convertRowIndexToModel(tableProduk.getSelectedRow());
            double karat = (double) tableProduk.getModel().getValueAt(idx, 4);
            Produk produk = new Produk();
            produk.setId((int) tableProduk.getModel().getValueAt(idx, 0));
            produk.setNama((String) tableProduk.getModel().getValueAt(idx, 1));
            produk.setDeskripsi((String) tableProduk.getModel().getValueAt(idx, 2));
            produk.setBerat((double) tableProduk.getModel().getValueAt(idx, 3));
            produk.setKarat((int) karat);
            produk.setStatus((String) tableProduk.getModel().getValueAt(idx, 5));
            produk.setTipeBarang((String) tableProduk.getModel().getValueAt(idx, 6));
            produk.setKategori((String) tableProduk.getModel().getValueAt(idx, 7));
            produk.setSupplier((String) tableProduk.getModel().getValueAt(idx, 8));
            produk.setHargaBeli((int) tableProduk.getModel().getValueAt(idx, 9));         
            produk.setTanggalBeli((Date)tableProduk.getModel().getValueAt(idx, 10));

            JDialog editProduk = new EditProduk(produk);
            editProduk.setLocationRelativeTo(this);
            editProduk.setVisible(true);

            editProduk.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent we) {
                    tableProduk.setModel(getAllProdukPanel());
                    produkModel = tableProduk.getModel();
                    setUpRowFilter();
                    initModel();
                }
            });
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    public static void main(String args[]) {
        Controller con = new Controller();
        JFrame a = new JFrame();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ProdukPanel panel = new ProdukPanel();
        //a.setPreferredSize(dialog.getPreferredSize());
        a.setSize(panel.getPreferredSize());
        a.setContentPane(panel);
        a.setVisible(true);
        System.out.println("Width : " + a.getWidth());
        System.out.println("Height : " + a.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleText;
    private javax.swing.JButton buttonKategori;
    private javax.swing.JButton buttonSupplier;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JLabel dateText;
    private javax.swing.JTextField fieldCari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlabel;
    private javax.swing.JLabel jlabel1;
    private javax.swing.JLabel labelDeskripsi;
    private javax.swing.JLabel labelHargaBeli;
    private javax.swing.JLabel labelKarat;
    private javax.swing.JLabel labelKategori;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelSupplier;
    private javax.swing.JLabel labelType;
    private javax.swing.JLabel labelWeight;
    private javax.swing.JPanel panelInfoProduk;
    private javax.swing.JTable tableProduk;
    private javax.swing.JLabel timeText;
    // End of variables declaration//GEN-END:variables
}
