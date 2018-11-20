package popups;

import customComponents.*;
import database.Controller;
import static database.Controller.getAllKategori;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Xenon
 */
public class Kategori extends javax.swing.JDialog {

    /**
     * Creates new form TambahPelanggan
     */
    public Kategori(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public Kategori() {
        initComponents();
        System.out.println("Masuk sini");
        btnHapus.setEnabled(false);
        btnUbah.setEnabled(false);

        ListSelectionModel lsm = listKategori.getSelectionModel();
        lsm.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (lse.getValueIsAdjusting()) {
                    btnHapus.setEnabled(true);
                    btnUbah.setEnabled(true);
                    fieldNamaKategori.setText(listKategori.getModel().getElementAt(listKategori.getSelectedIndex()));
                    fieldNamaKategori.setForeground(Color.BLACK);
                }
            }
        });
        this.setFocusable(true);
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
        fieldNamaKategori = new javax.swing.JTextField();
        fieldNamaKategori = new CorneredJTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        listKategori = new javax.swing.JList<>();
        btnHapus = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnUbah = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tambah Pelanggan");
        setSize(new java.awt.Dimension(400, 550));

        TambahPelangganPanel.setBackground(new java.awt.Color(255, 231, 192));
        TambahPelangganPanel.setPreferredSize(new java.awt.Dimension(400, 550));

        TitleText.setBackground(new java.awt.Color(102, 0, 0));
        TitleText.setFont(new java.awt.Font("Myriad Pro", 0, 36)); // NOI18N
        TitleText.setForeground(new java.awt.Color(102, 0, 0));
        TitleText.setText("Kategori");

        jLabel1.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("Nama Kategori");

        fieldNamaKategori.setForeground(java.awt.Color.gray);
        fieldNamaKategori.setText("Masukkan nama kategori.");
        fieldNamaKategori.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                fieldNamaKategoriFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                fieldNamaKategoriFocusLost(evt);
            }
        });

        listKategori.setModel(getAllKategori());
        jScrollPane2.setViewportView(listKategori);

        btnHapus.setBackground(new java.awt.Color(89, 38, 1));
        btnHapus.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnHapus.setForeground(java.awt.Color.white);
        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnTambah.setBackground(new java.awt.Color(89, 38, 1));
        btnTambah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnTambah.setForeground(java.awt.Color.white);
        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnUbah.setBackground(new java.awt.Color(89, 38, 1));
        btnUbah.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        btnUbah.setForeground(java.awt.Color.white);
        btnUbah.setText("Ubah");
        btnUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Myriad Pro", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 0));
        jLabel2.setText("List Kategori");

        javax.swing.GroupLayout TambahPelangganPanelLayout = new javax.swing.GroupLayout(TambahPelangganPanel);
        TambahPelangganPanel.setLayout(TambahPelangganPanelLayout);
        TambahPelangganPanelLayout.setHorizontalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, TambahPelangganPanelLayout.createSequentialGroup()
                                .addComponent(btnHapus)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(btnUbah)
                                .addGap(54, 54, 54)
                                .addComponent(btnTambah))
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TitleText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldNamaKategori, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        TambahPelangganPanelLayout.setVerticalGroup(
            TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahPelangganPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(TitleText)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TambahPelangganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TambahPelangganPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldNamaKategoriFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaKategoriFocusLost
        if (fieldNamaKategori.getText().equals("")) {
            fieldNamaKategori.setText("Masukkan nama kategori.");
            fieldNamaKategori.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_fieldNamaKategoriFocusLost

    private void fieldNamaKategoriFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_fieldNamaKategoriFocusGained
        if (fieldNamaKategori.getText().equals("Masukkan nama kategori.")) {
            fieldNamaKategori.setText("");
            fieldNamaKategori.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_fieldNamaKategoriFocusGained

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        listKategori.clearSelection();
        int reply = JOptionPane.showConfirmDialog(null, "Menghapus kategori " + fieldNamaKategori.getText(), "Hapus Kategori", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            Controller.deleteKategori(fieldNamaKategori.getText());
        }
        listKategori.setModel(getAllKategori());
        fieldNamaKategori.setText("Masukkan nama kategori.");
        fieldNamaKategori.setForeground(Color.GRAY);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahActionPerformed
        String namaKategori = fieldNamaKategori.getText();
        String namaTerpilih = listKategori.getModel().getElementAt(listKategori.getSelectedIndex());
        boolean isExist = false;
        for (int i = 0; i < listKategori.getModel().getSize(); i++) {
            if (listKategori.getModel().getElementAt(i).equalsIgnoreCase(namaKategori)) {
                isExist = true;
            }
        }
        if (isExist) {
            int reply = JOptionPane.showConfirmDialog(null, "Kategori sudah ada, apakah ingin melanjutkan?",
                    "Perhatian", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Controller.updateKategori(namaKategori, namaTerpilih);
            }
        } else {
            Controller.updateKategori(namaKategori, namaTerpilih);
        }
        listKategori.setModel(getAllKategori());
        fieldNamaKategori.setText("Masukkan nama kategori.");
        fieldNamaKategori.setForeground(Color.GRAY);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnUbahActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        listKategori.clearSelection();
        String namaKategori = fieldNamaKategori.getText();
        boolean isExist = false;
        for (int i = 0; i < listKategori.getModel().getSize(); i++) {
            if (listKategori.getModel().getElementAt(i).equalsIgnoreCase(namaKategori)) {
                isExist = true;
            }
        }
        if (isExist) {
            int reply = JOptionPane.showConfirmDialog(null, "Kategori sudah ada, apakah ingin melanjutkan?", "Perhatian", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                Controller.addKategori(namaKategori);
            }
        } else {
            Controller.addKategori(namaKategori);
        }
        listKategori.setModel(getAllKategori());
        fieldNamaKategori.setText("Masukkan nama kategori.");
        fieldNamaKategori.setForeground(Color.GRAY);
        btnUbah.setEnabled(false);
        btnHapus.setEnabled(false);
    }//GEN-LAST:event_btnTambahActionPerformed

    public static void main(String args[]) {
        JFrame a = new JFrame();
        Kategori dialog = new Kategori(a, true);
        //a.setPreferredSize(dialog.getPreferredSize());
        dialog.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TambahPelangganPanel;
    private javax.swing.JLabel TitleText;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnUbah;
    private javax.swing.JTextField fieldNamaKategori;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listKategori;
    // End of variables declaration//GEN-END:variables
}
