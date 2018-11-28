package popups;

import POJO.SupplierData;
import customComponents.*;
import database.Controller;
import static database.Controller.getAllSupplier;
import static database.Controller.getSupplierModel;
import java.awt.Color;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Xenon
 */
public class DetailTransaksi extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */


    public DetailTransaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DetailTransaksi() {
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

        TambahPelangganPanel = new javax.swing.JPanel();
        TitleText = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jlabel6 = new javax.swing.JLabel();
        textMetodeBayar = new javax.swing.JLabel();
        jlabel7 = new javax.swing.JLabel();
        textTotal = new javax.swing.JLabel();
        textDate = new javax.swing.JLabel();
        textStaf = new javax.swing.JLabel();
        textCustomerId = new javax.swing.JLabel();
        textNamaCustomer = new javax.swing.JLabel();
        textPhone = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        textAlamat = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Selling Note");

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Date :");

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("Staff Name :");

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Customer ID :");

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Name : ");

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Address : ");

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Phone Number :");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jlabel6.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel6.setForeground(new java.awt.Color(102, 0, 0));
        jlabel6.setText("Total : ");

        textMetodeBayar.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        textMetodeBayar.setForeground(new java.awt.Color(102, 0, 0));
        textMetodeBayar.setText("<HargaTotal>");

        jlabel7.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        jlabel7.setForeground(new java.awt.Color(102, 0, 0));
        jlabel7.setText("Metode Bayar :");

        textTotal.setFont(new java.awt.Font("Myriad Pro", 0, 18)); // NOI18N
        textTotal.setForeground(new java.awt.Color(102, 0, 0));
        textTotal.setText("<HargaTotal>");

        textDate.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        textDate.setForeground(new java.awt.Color(102, 0, 0));
        textDate.setText("<HargaTotal>");

        textStaf.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        textStaf.setForeground(new java.awt.Color(102, 0, 0));
        textStaf.setText("<HargaTotal>");

        textCustomerId.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        textCustomerId.setForeground(new java.awt.Color(102, 0, 0));
        textCustomerId.setText("<HargaTotal>");

        textNamaCustomer.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        textNamaCustomer.setForeground(new java.awt.Color(102, 0, 0));
        textNamaCustomer.setText("<HargaTotal>");

        textPhone.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        textPhone.setForeground(new java.awt.Color(102, 0, 0));
        textPhone.setText("<HargaTotal>");

        textAlamat.setColumns(21);
        textAlamat.setRows(4);
        textAlamat.setEditable(false);
        jScrollPane2.setViewportView(textAlamat);

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(12, 12, 12)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDate)
                            .addComponent(textStaf)))
                    .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                            .addComponent(TitleText)
                            .addGap(256, 256, 256)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahPelangganPanelLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel4))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahPelangganPanelLayout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(jLabel5))
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGap(18, 18, 18)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textCustomerId)
                                .addComponent(textNamaCustomer)
                                .addComponent(textPhone)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(42, 42, 42))
                        .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jlabel6)
                                .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(textMetodeBayar)
                                .addComponent(textTotal)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 833, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        TambahPelangganPanelLayout.setVerticalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(TitleText)
                        .addGap(20, 20, 20)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textDate))
                        .addGap(18, 18, 18)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(textStaf)))
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(textCustomerId))
                        .addGap(18, 18, 18)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(textNamaCustomer))
                        .addGap(18, 18, 18)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(textPhone))
                        .addGap(18, 18, 18)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel6)
                    .addComponent(textTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textMetodeBayar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        JFrame a = new JFrame();
        DetailTransaksi dialog = new DetailTransaksi(a, true);
        //a.setPreferredSize(dialog.getPreferredSize());
        dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel jlabel6;
    private javax.swing.JLabel jlabel7;
    private javax.swing.JTextArea textAlamat;
    private javax.swing.JLabel textCustomerId;
    private javax.swing.JLabel textDate;
    private javax.swing.JLabel textMetodeBayar;
    private javax.swing.JLabel textNamaCustomer;
    private javax.swing.JLabel textPhone;
    private javax.swing.JLabel textStaf;
    private javax.swing.JLabel textTotal;
    // End of variables declaration//GEN-END:variables
}
