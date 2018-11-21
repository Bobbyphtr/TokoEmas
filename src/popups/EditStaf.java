package popups;

import POJO.Staf;
import customComponents.*;
import database.Controller;
import static database.Controller.updateStaf;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Xenon
 */
public class EditStaf extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */
    Staf staf;

    public EditStaf(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public EditStaf(Staf staf) {
        initComponents();

        this.staf = staf;

        fieldNama.setText(staf.getNama());
        emailField.setText(staf.getEmail());
        posisiField.setText(staf.getPosisi());
        gajiField.setText(String.valueOf(staf.getGaji()));
        noTelpField.setText(staf.getNoTelp());
        alamatArea.setText(staf.getAlamat());
        fieldKuantitasHadiah.setText(String.valueOf(staf.getReward()));
        deskripsiHadiahArea.setText(staf.getDekripsiReward());
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
        jLabel1 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        emailField = new CorneredJTextField();
        jLabel2 = new javax.swing.JLabel();
        noTelpField = new javax.swing.JTextField();
        noTelpField = new CorneredJTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatArea = new javax.swing.JTextArea();
        alamatArea = new CorneredJTextArea();
        btnOK = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        posisiField = new javax.swing.JTextField();
        noTelpField = new CorneredJTextField();
        gajiField = new javax.swing.JTextField();
        noTelpField = new CorneredJTextField();
        jLabel6 = new javax.swing.JLabel();
        TitleText1 = new javax.swing.JLabel();
        TitleText2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fieldKuantitasHadiah = new javax.swing.JTextField();
        fieldKuantitasHadiah = new CorneredJTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        deskripsiHadiahArea = new javax.swing.JTextArea();
        alamatArea = new CorneredJTextArea();
        btnHapus = new javax.swing.JButton();
        fieldNama = new javax.swing.JTextField();
        fieldNama = new CorneredJTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nama");

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                emailFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Email");

        noTelpField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                noTelpFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                noTelpFieldFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("No Telepon");

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Alamat");

        alamatArea.setColumns(20);
        alamatArea.setRows(5);
        alamatArea.setBorder(null);
        jScrollPane1.setViewportView(alamatArea);
        jScrollPane1.setBorder(null);

        btnOK.setBackground(new java.awt.Color(89, 38, 1));
        btnOK.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnOK.setForeground(java.awt.Color.white);
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Posisi");

        posisiField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                posisiFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                posisiFieldFocusLost(evt);
            }
        });

        gajiField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                gajiFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                gajiFieldFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Gaji");

        TitleText1.setBackground(new java.awt.Color(102, 0, 0));
        TitleText1.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText1.setForeground(new java.awt.Color(102, 0, 0));
        TitleText1.setText("Edit Staf");

        TitleText2.setBackground(new java.awt.Color(102, 0, 0));
        TitleText2.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        TitleText2.setForeground(new java.awt.Color(102, 0, 0));
        TitleText2.setText("Hadiah");

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Kuantitas Hadiah");

        fieldKuantitasHadiah.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldKuantitasHadiahFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldKuantitasHadiahFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 0, 0));
        jLabel8.setText("Deskripsi Hadiah");

        deskripsiHadiahArea.setColumns(20);
        deskripsiHadiahArea.setRows(5);
        deskripsiHadiahArea.setBorder(null);
        jScrollPane2.setViewportView(deskripsiHadiahArea);
        jScrollPane1.setBorder(null);

        btnHapus.setBackground(new java.awt.Color(89, 38, 1));
        btnHapus.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnHapus.setForeground(java.awt.Color.white);
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        fieldNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNamaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(emailField, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(posisiField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(gajiField)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahPelangganPanelLayout.createSequentialGroup()
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TitleText2)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(noTelpField)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(fieldKuantitasHadiah)
                            .addComponent(jScrollPane2)
                            .addComponent(fieldNama, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)))
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addComponent(TitleText1)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        TambahPelangganPanelLayout.setVerticalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TitleText1)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(posisiField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gajiField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noTelpField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TitleText2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldKuantitasHadiah, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 720, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldFocusGained

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldFocusLost

    private void posisiFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_posisiFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_posisiFieldFocusGained

    private void posisiFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_posisiFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_posisiFieldFocusLost

    private void gajiFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gajiFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_gajiFieldFocusGained

    private void gajiFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_gajiFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_gajiFieldFocusLost

    private void fieldKuantitasHadiahFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldKuantitasHadiahFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKuantitasHadiahFocusGained

    private void fieldKuantitasHadiahFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldKuantitasHadiahFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldKuantitasHadiahFocusLost

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        Staf staf = new Staf();
        staf.setId(this.staf.getId());
        staf.setNama(fieldNama.getText());
        staf.setEmail(emailField.getText());
        staf.setPosisi(posisiField.getText());
        staf.setGaji(Integer.parseInt(gajiField.getText()));
        staf.setNoTelp(noTelpField.getText());
        staf.setAlamat(alamatArea.getText());
        staf.setReward(Integer.parseInt(fieldKuantitasHadiah.getText()));
        staf.setDekripsiReward(deskripsiHadiahArea.getText());
        updateStaf(staf);
        JOptionPane.showMessageDialog(this, "Update berhasil!");
        this.dispose();
    }//GEN-LAST:event_btnOKActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus " + staf.getNama(), "Hapus Staf", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Controller.deleteStafbyId(staf.getId());
            this.dispose();
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void noTelpFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noTelpFieldFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_noTelpFieldFocusLost

    private void noTelpFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_noTelpFieldFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_noTelpFieldFocusGained

    private void fieldNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaFocusGained

    private void fieldNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldNamaFocusLost
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditStaf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditStaf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditStaf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditStaf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                EditStaf dialog = new EditStaf(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText1;
    private javax.swing.JLabel TitleText2;
    private javax.swing.JTextArea alamatArea;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnOK;
    private javax.swing.JTextArea deskripsiHadiahArea;
    private javax.swing.JTextField emailField;
    private javax.swing.JTextField fieldKuantitasHadiah;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField gajiField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField noTelpField;
    private javax.swing.JTextField posisiField;
    // End of variables declaration//GEN-END:variables
}
