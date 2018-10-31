/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tokoemas;

/**
 *
 * @author ysuta
 */
public class Rekap extends javax.swing.JPanel {

    /**
     * Creates new form Rekap
     */
    public Rekap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_TotalPenjualan = new javax.swing.JLabel();
        label_tanggal = new javax.swing.JLabel();
        label_Rekap1 = new javax.swing.JLabel();
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

        setBackground(new java.awt.Color(255, 231, 192));

        label_TotalPenjualan.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_TotalPenjualan.setForeground(new java.awt.Color(0, 0, 0));
        label_TotalPenjualan.setText("Total Penjualan:");

        label_tanggal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label_tanggal.setForeground(new java.awt.Color(0, 0, 0));
        label_tanggal.setText("<Tanggal>");

        label_Rekap1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        label_Rekap1.setForeground(new java.awt.Color(0, 0, 0));
        label_Rekap1.setText("REKAP");

        table_Pegawai.setBackground(new java.awt.Color(255, 255, 255));
        table_Pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Ranking Pegawai"
            }
        ));
        table_Pegawai.setRowHeight(50);
        jScrollPane1.setViewportView(table_Pegawai);
        if (table_Pegawai.getColumnModel().getColumnCount() > 0) {
            table_Pegawai.getColumnModel().getColumn(0).setHeaderValue("Ranking Pelanggan");
        }

        table_Transaksi.setBackground(new java.awt.Color(255, 255, 255));
        table_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Tindakan", "Judul"
            }
        ));
        table_Transaksi.setRowHeight(50);
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

        label_TotalPembelian.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_TotalPembelian.setForeground(new java.awt.Color(0, 0, 0));
        label_TotalPembelian.setText("Total Pembelian:");

        label_Keuntungan.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_Keuntungan.setForeground(new java.awt.Color(0, 0, 0));
        label_Keuntungan.setText("Keuntungan:");

        label_PenjualanVar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_PenjualanVar.setForeground(new java.awt.Color(0, 0, 0));
        label_PenjualanVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_PenjualanVar.setText("Rp. 1.000.000,-");
        label_PenjualanVar.setToolTipText("");

        label_PembelianVar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_PembelianVar.setForeground(new java.awt.Color(0, 0, 0));
        label_PembelianVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_PembelianVar.setText("Rp. 1.000.000,-");
        label_PembelianVar.setToolTipText("");

        label_KeuntunganVar.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        label_KeuntunganVar.setForeground(new java.awt.Color(0, 0, 0));
        label_KeuntunganVar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        label_KeuntunganVar.setText("Rp. 1.000.000,-");
        label_KeuntunganVar.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_tanggal)
                            .addComponent(label_Rekap1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_PenjualanVar)
                            .addComponent(label_TotalPenjualan))
                        .addGap(145, 145, 145)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_TotalPembelian)
                            .addComponent(label_PembelianVar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label_Keuntungan, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label_KeuntunganVar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(label_Rekap1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label_tanggal)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_TotalPenjualan)
                    .addComponent(label_TotalPembelian)
                    .addComponent(label_Keuntungan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(label_PenjualanVar)
                    .addComponent(label_PembelianVar)
                    .addComponent(label_KeuntunganVar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel label_Keuntungan;
    private javax.swing.JLabel label_KeuntunganVar;
    private javax.swing.JLabel label_PembelianVar;
    private javax.swing.JLabel label_PenjualanVar;
    private javax.swing.JLabel label_Rekap1;
    private javax.swing.JLabel label_TotalPembelian;
    private javax.swing.JLabel label_TotalPenjualan;
    private javax.swing.JLabel label_tanggal;
    private javax.swing.JTable table_Pegawai;
    private javax.swing.JTable table_Pelanggan;
    private javax.swing.JTable table_Transaksi;
    // End of variables declaration//GEN-END:variables
}
