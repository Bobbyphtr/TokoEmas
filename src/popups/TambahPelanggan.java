package popups;

import customComponents.*;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;

/**
 *
 * @author Xenon
 */
public class TambahPelanggan extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */
    public TambahPelanggan(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public TambahPelanggan() {
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
        tambahButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Tambah Pelanggan");

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

        tambahButton.setBackground(new java.awt.Color(89, 38, 1));
        tambahButton.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        tambahButton.setForeground(java.awt.Color.white);
        tambahButton.setText("Tambah");

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(fieldNoTelp, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(TitleText)
                            .addComponent(fieldNama))))
                .addGap(36, 36, 36))
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
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tambahButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
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

    public static void main(String args[]) {
        JFrame a = new JFrame();
        TambahPelanggan dialog = new TambahPelanggan(a,true);
        //a.setPreferredSize(dialog.getPreferredSize());
       dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText;
    private javax.swing.JTextField fieldEmail;
    private javax.swing.JTextField fieldNama;
    private javax.swing.JTextField fieldNoTelp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextArea textAreaAlamat;
    // End of variables declaration//GEN-END:variables
}
