/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package panels;

import database.Controller;
import static database.Controller.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ysuta
 */
public class RekapPanel extends javax.swing.JPanel {

    /**
     * Creates new form Rekap
     */
    private String[] dateAndTime;

    private String totalPenjualan, totalPembelian, totalProfit;
    
    private DefaultTableModel modelTransaksi, modelPegawai, modelPelanggan;

    public RekapPanel() {
        initTableModel();
        initComponents();
        syncDate();
        initAudit();
        label_PenjualanVar.setText(totalPenjualan);
        label_PembelianVar.setText(totalPembelian);
        label_KeuntunganVar.setText(totalProfit);
        removeColumn();
        
    }
    
    private void initTableModel() {
        modelTransaksi = getTransaksi();
        modelPegawai = getRankingPegawai();
    }

    private void syncDate() {
        dateAndTime = getDateAndTime();
        dateText.setText(dateAndTime[1]);
        Timer date = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dateAndTime = getDateAndTime();
                dateText.setText(dateAndTime[1]);
            }
        });
        date.start();
    }

    private void initAudit() {
        int penjualan = getTotalPenjualan();
        int pembelian = getTotalPembelian();
        int profit = penjualan - pembelian;
        System.out.println(profit);
        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        kursIndonesia.setDecimalFormatSymbols(formatRp);

        totalPembelian = kursIndonesia.format(pembelian) + ",-";
        totalPenjualan = kursIndonesia.format(penjualan) + ",-";
        totalProfit = kursIndonesia.format(profit) + ",-";
    }
    
    private void removeColumn() {
        TableColumn idBarang = table_Transaksi.getColumnModel().getColumn(2);
        TableColumn idCustomer = table_Transaksi.getColumnModel().getColumn(3);
        TableColumn idPekerja = table_Transaksi.getColumnModel().getColumn(4);
        TableColumn metodeBayar = table_Transaksi.getColumnModel().getColumn(5);
        TableColumn hargaJual = table_Transaksi.getColumnModel().getColumn(6);
        TableColumn tanggalJual = table_Transaksi.getColumnModel().getColumn(7);
        
        table_Transaksi.getColumnModel().removeColumn(idBarang);
        table_Transaksi.getColumnModel().removeColumn(idCustomer);
        table_Transaksi.getColumnModel().removeColumn(idPekerja);
        table_Transaksi.getColumnModel().removeColumn(metodeBayar);
        //table_Transaksi.getColumnModel().removeColumn(hargaJual);
        //table_Transaksi.getColumnModel().removeColumn(tanggalJual);
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
        label_TotalPenjualan = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Pegawai = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_Transaksi = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_Pelanggan = new javax.swing.JTable();
        label_TotalPembelian = new javax.swing.JLabel();
        label_Keuntungan = new javax.swing.JLabel();
        label_PenjualanVar = new javax.swing.JLabel();
        label_PembelianVar = new javax.swing.JLabel();
        label_KeuntunganVar = new javax.swing.JLabel();
        TitleText1 = new javax.swing.JLabel();
        dateText = new javax.swing.JLabel();

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        setBackground(new java.awt.Color(255, 231, 192));

        label_TotalPenjualan.setBackground(new java.awt.Color(102, 0, 0));
        label_TotalPenjualan.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        label_TotalPenjualan.setForeground(new java.awt.Color(0, 0, 0));
        label_TotalPenjualan.setText("Total Penjualan:");

        table_Pegawai.setBackground(new java.awt.Color(255, 255, 255));
        table_Pegawai.setModel(modelPegawai);
        table_Pegawai.setRowHeight(50);
        jScrollPane1.setViewportView(table_Pegawai);

        table_Transaksi.setAutoCreateRowSorter(true);
        table_Transaksi.setBackground(new java.awt.Color(255, 255, 255));
        table_Transaksi.setModel(modelTransaksi);
        table_Transaksi.setRowHeight(50);
        table_Transaksi.getColumn("Tindakan").setCellEditor(new CustomTableCell.RekapTransaksiCell(new JCheckBox(), modelTransaksi));
        table_Transaksi.getColumn("Tindakan").setCellRenderer(new CustomTableCell.RekapTransaksiCell(new JCheckBox(), modelTransaksi));
        jScrollPane2.setViewportView(table_Transaksi);

        table_Pelanggan.setBackground(new java.awt.Color(255, 255, 255));
        table_Pelanggan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Ranking Pelanggan"
            }
        ));
        table_Pelanggan.setRowHeight(50);
        jScrollPane3.setViewportView(table_Pelanggan);
        if (table_Pelanggan.getColumnModel().getColumnCount() > 0) {
            table_Pelanggan.getColumnModel().getColumn(0).setHeaderValue("Ranking Pelanggan");
        }

        label_TotalPembelian.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        label_TotalPembelian.setForeground(new java.awt.Color(0, 0, 0));
        label_TotalPembelian.setText("Total Pembelian:");

        label_Keuntungan.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 24)); // NOI18N
        label_Keuntungan.setForeground(new java.awt.Color(0, 0, 0));
        label_Keuntungan.setText("Keuntungan:");

        label_PenjualanVar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        label_PenjualanVar.setForeground(new java.awt.Color(0, 0, 0));
        label_PenjualanVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_PenjualanVar.setText("Rp. 1.000.000,-");
        label_PenjualanVar.setToolTipText("");

        label_PembelianVar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        label_PembelianVar.setForeground(new java.awt.Color(0, 0, 0));
        label_PembelianVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_PembelianVar.setText("Rp. 1.000.000,-");
        label_PembelianVar.setToolTipText("");

        label_KeuntunganVar.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 24)); // NOI18N
        label_KeuntunganVar.setForeground(new java.awt.Color(0, 0, 0));
        label_KeuntunganVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_KeuntunganVar.setText("Rp. 1.000.000,-");
        label_KeuntunganVar.setToolTipText("");

        TitleText1.setBackground(new java.awt.Color(102, 0, 0));
        TitleText1.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText1.setForeground(new java.awt.Color(102, 0, 0));
        TitleText1.setText("Rekap");

        dateText.setBackground(new java.awt.Color(102, 0, 0));
        dateText.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        dateText.setForeground(new java.awt.Color(102, 0, 0));
        dateText.setText("<Tanggal>");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateText)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_TotalPenjualan)
                                    .addComponent(label_PenjualanVar))
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_TotalPembelian)
                                    .addComponent(label_PembelianVar))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(label_Keuntungan, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(label_KeuntunganVar, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addComponent(TitleText1))
                        .addContainerGap(161, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(TitleText1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dateText)
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_TotalPenjualan)
                    .addComponent(label_TotalPembelian)
                    .addComponent(label_Keuntungan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_PenjualanVar)
                    .addComponent(label_PembelianVar)
                    .addComponent(label_KeuntunganVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64))
        );
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        Controller controller = new Controller();
        JFrame a = new JFrame();
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RekapPanel panel = new RekapPanel();
        //a.setPreferredSize(dialog.getPreferredSize());
        a.setSize(panel.getPreferredSize());
        a.setContentPane(panel);
        a.setVisible(true);
        System.out.println("Width : " + a.getWidth());
        System.out.println("Height : " + a.getHeight());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleText1;
    private javax.swing.JLabel dateText;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_Keuntungan;
    private javax.swing.JLabel label_KeuntunganVar;
    private javax.swing.JLabel label_PembelianVar;
    private javax.swing.JLabel label_PenjualanVar;
    private javax.swing.JLabel label_TotalPembelian;
    private javax.swing.JLabel label_TotalPenjualan;
    private javax.swing.JTable table_Pegawai;
    private javax.swing.JTable table_Pelanggan;
    private javax.swing.JTable table_Transaksi;
    // End of variables declaration//GEN-END:variables
}
