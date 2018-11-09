package popups;

import customComponents.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author Xenon
 */
public class EditPelanggan extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */
    public EditPelanggan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public EditPelanggan() {
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
        fieldNama = new javax.swing.JTextField();
        fieldNama = new CorneredJTextField();
        fieldEmail = new javax.swing.JTextField();
        fieldEmail = new CorneredJTextField();
        jLabel2 = new javax.swing.JLabel();
        fieldNoTelp = new javax.swing.JTextField();
        fieldNoTelp = new CorneredJTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaAlamat = new javax.swing.JTextArea();
        textAreaAlamat = new CorneredJTextArea();
        btnSimpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fieldKuantitasReward = new javax.swing.JTextField();
        fieldKuantitasReward = new CorneredJTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldDeskripsiReward = new javax.swing.JTextArea();
        fieldDeskripsiReward = new CorneredJTextArea();
        jLabel7 = new javax.swing.JLabel();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Ubah Pelanggan");

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nama");

        fieldNama.setForeground(java.awt.Color.gray);
        fieldNama.setText("Masukan nama pelanggan.");
        fieldNama.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNamaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNamaFocusLost(evt);
            }
        });

        fieldEmail.setForeground(java.awt.Color.gray);
        fieldEmail.setText("Masukan email.");
        fieldEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldEmailFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("Email");

        fieldNoTelp.setForeground(java.awt.Color.gray);
        fieldNoTelp.setText("Masukan no telp.");
        fieldNoTelp.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNoTelpFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNoTelpFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("No Telepon");

        jLabel4.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Alamat");

        textAreaAlamat.setColumns(20);
        textAreaAlamat.setForeground(java.awt.Color.gray);
        textAreaAlamat.setRows(5);
        textAreaAlamat.setText("Masukan alamat.");
        textAreaAlamat.setBorder(null);
        textAreaAlamat.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textAreaAlamatFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textAreaAlamatFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(textAreaAlamat);
        jScrollPane1.setBorder(null);

        btnSimpan.setBackground(new java.awt.Color(89, 38, 1));
        btnSimpan.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnSimpan.setForeground(java.awt.Color.white);
        btnSimpan.setText("Simpan");

        jLabel5.setFont(new java.awt.Font("Myriad Pro", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("Reward -  opsional");

        fieldKuantitasReward.setForeground(java.awt.Color.gray);
        fieldKuantitasReward.setText("Masukan kuantitas reward. (nominal  voucher)");
        fieldKuantitasReward.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldKuantitasRewardFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldKuantitasRewardFocusLost(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 0, 0));
        jLabel6.setText("Kuantitas Reward");

        fieldDeskripsiReward.setColumns(20);
        fieldDeskripsiReward.setForeground(java.awt.Color.gray);
        fieldDeskripsiReward.setRows(5);
        fieldDeskripsiReward.setText("Masukan deskripsi reward - dapat berupa reward deskriptif\nseperti suvenir, produk, tiket dan lain lain.");
        fieldDeskripsiReward.setBorder(null);
        fieldDeskripsiReward.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldDeskripsiRewardFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldDeskripsiRewardFocusLost(evt);
            }
        });
        jScrollPane2.setViewportView(fieldDeskripsiReward);
        jScrollPane2.setBorder(null);

        jLabel7.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("Deskripsi Reward");

        btnHapus.setBackground(new java.awt.Color(89, 38, 1));
        btnHapus.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnHapus.setForeground(java.awt.Color.white);
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fieldKuantitasReward, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TambahPelangganPanelLayout.createSequentialGroup()
                                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3)
                                        .addComponent(fieldNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel1)
                                        .addComponent(TitleText)
                                        .addComponent(fieldNama))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(36, 36, 36))))
        );
        TambahPelangganPanelLayout.setVerticalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TitleText)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldKuantitasReward, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNamaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusGained
        if (fieldNama.getText().equals("Masukan nama pelanggan.")) {
            fieldNama.setText("");
            fieldNama.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldNamaFocusGained

    private void fieldNamaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaFocusLost
        if (fieldNama.getText().equals("")) {
            fieldNama.setText("Masukan nama pelanggan");
            fieldNama.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldNamaFocusLost

    private void fieldEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldEmailFocusGained
        if (fieldEmail.getText().equals("Masukan email.")) {
            fieldEmail.setText("");
            fieldEmail.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldEmailFocusGained

    private void fieldEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldEmailFocusLost
        if (fieldEmail.getText().equals("")) {
            fieldEmail.setText("Masukan email.");
            fieldEmail.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldEmailFocusLost

    private void fieldNoTelpFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNoTelpFocusGained
        if (fieldNoTelp.getText().equals("Masukan no telp.")) {
            fieldNoTelp.setText("");
            fieldNoTelp.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldNoTelpFocusGained

    private void fieldNoTelpFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNoTelpFocusLost
        if (fieldNoTelp.getText().equals("")) {
            fieldNoTelp.setText("Masukan no telp.");
            fieldNoTelp.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldNoTelpFocusLost

    private void textAreaAlamatFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textAreaAlamatFocusGained
        if (textAreaAlamat.getText().equals("Masukan alamat.")) {
            textAreaAlamat.setText("");
            textAreaAlamat.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_textAreaAlamatFocusGained

    private void textAreaAlamatFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textAreaAlamatFocusLost
        if (textAreaAlamat.getText().equals("")) {
            textAreaAlamat.setText("Masukan alamat.");
            textAreaAlamat.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_textAreaAlamatFocusLost

    private void fieldKuantitasRewardFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldKuantitasRewardFocusGained
        if (fieldKuantitasReward.getText().equals("Masukan kuantitas reward. (nominal  voucher)")) {
            fieldKuantitasReward.setText("");
            fieldKuantitasReward.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldKuantitasRewardFocusGained

    private void fieldKuantitasRewardFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldKuantitasRewardFocusLost
        if (fieldKuantitasReward.getText().equals("")) {
            fieldKuantitasReward.setText("Masukan kuantitas reward. (nominal  voucher)");
            fieldKuantitasReward.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldKuantitasRewardFocusLost

    private void fieldDeskripsiRewardFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDeskripsiRewardFocusGained
        if (fieldDeskripsiReward.getText().equals("Masukan deskripsi reward - dapat berupa reward deskriptif\nseperti suvenir, produk, tiket dan lain lain.")) {
            fieldDeskripsiReward.setText("");
            fieldDeskripsiReward.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldDeskripsiRewardFocusGained

    private void fieldDeskripsiRewardFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldDeskripsiRewardFocusLost
        if (fieldDeskripsiReward.getText().equals("")) {
            fieldDeskripsiReward.setText("Masukan deskripsi reward - dapat berupa reward deskriptif\nseperti suvenir, produk, tiket dan lain lain.");
            fieldDeskripsiReward.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldDeskripsiRewardFocusLost

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHapusActionPerformed

    public static void main(String args[]) {
        JFrame a = new JFrame();
        EditPelanggan dialog = new EditPelanggan(a, true);
        //a.setPreferredSize(dialog.getPreferredSize());
        dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JTextArea fieldDeskripsiReward;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldKuantitasReward;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNoTelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea textAreaAlamat;
    // End of variables declaration//GEN-END:variables
}
