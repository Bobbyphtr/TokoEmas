/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popups;

import java.awt.Color;
import customComponents.*;
import static database.Controller.getPelangganDialog;
import java.awt.Window;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumn;
import panels.TransaksiPanel;
/**
 *
 * @author ysuta
 */
public class PilihPelanggan extends javax.swing.JPanel {

    /**
     * Creates new form PilihStaff
     */
    
    JLabel labelNama;
    int idPelanggan;
    TransaksiPanel transaksi;
    
    public PilihPelanggan() {
        initComponents();
    }
    
    public PilihPelanggan(JLabel labelNama, TransaksiPanel transaksi) {
        this.labelNama = labelNama;
        this.transaksi = transaksi;
        initComponents();
        
        tablePelanggan.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                idPelanggan = (int) tablePelanggan.getModel().getValueAt(tablePelanggan.getSelectedRow(), 0);
                String nama = (String) tablePelanggan.getModel().getValueAt(tablePelanggan.getSelectedRow(), 1);
                fieldNama.setText(nama);
            }
        });
        
        TableColumn id = tablePelanggan.getColumnModel().getColumn(0);
        tablePelanggan.getColumnModel().removeColumn(id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleText = new javax.swing.JLabel();
        fieldNama = new javax.swing.JTextField();
        fieldNama = new CorneredJTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePelanggan = new javax.swing.JTable();
        buttonTambah = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 231, 192));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Pilih Pelanggan");

        fieldNama.setText("Masukan nama");
        fieldNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNamaFocusLost(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nama");

        tablePelanggan.setModel(getPelangganDialog());
        jScrollPane1.setViewportView(tablePelanggan);

        buttonTambah.setBackground(new java.awt.Color(89, 38, 1));
        buttonTambah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        buttonTambah.setForeground(java.awt.Color.white);
        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TitleText)
                        .addGap(118, 118, 118)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(TitleText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusGained
        if (fieldNama.getText().equals("Masukan nama")) {
            fieldNama.setText("");
            fieldNama.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldNamaFocusGained

    private void fieldNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusLost
        if (fieldNama.getText().equals("")) {
            fieldNama.setText("Masukan nama");
            fieldNama.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldNamaFocusLost

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        if (!fieldNama.getText().equals("Masukan nama")) {
            labelNama.setText(fieldNama.getText());
            transaksi.setIdPelanggan(idPelanggan);
            JComponent comp = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(comp);
            win.dispose();
        }
        
    }//GEN-LAST:event_buttonTambahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TitleText;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePelanggan;
    // End of variables declaration//GEN-END:variables
}
