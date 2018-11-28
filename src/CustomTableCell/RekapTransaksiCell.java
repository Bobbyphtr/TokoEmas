/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTableCell;

import POJO.Pelanggan;
import POJO.Produk;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import popups.DetailTransaksi;

/**
 *
 * @author ysuta
 */
public class RekapTransaksiCell extends DefaultCellEditor implements TableCellRenderer {

    protected JButton button;
    protected int row;
    
    protected DefaultTableModel tableTransaksi;

    public RekapTransaksiCell(JCheckBox checkBox, DefaultTableModel transaksi) {
        super(checkBox);
        this.tableTransaksi = transaksi;
        button = new JButton();
        
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idBarang = (int) tableTransaksi.getValueAt(row, 2);
                int idCustomer = (int) tableTransaksi.getValueAt(row, 3);
                int idPekerja = (int) tableTransaksi.getValueAt(row, 4);
                String metodeBayar = (String) tableTransaksi.getValueAt(row, 5);
                String hargaJual = (String) tableTransaksi.getValueAt(row, 6);
                String tanggalJual = (String) tableTransaksi.getValueAt(row, 7);
                
                JDialog detailTransaksi = new DetailTransaksi(idBarang, idCustomer, idPekerja, metodeBayar, hargaJual, tanggalJual);
                detailTransaksi.setLocationRelativeTo(null);
                detailTransaksi.setVisible(true);
                
            }
        });
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.row = row;
        
        button.setText("Lihat");
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        this.row = row;
        
        button.setText("Lihat");
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        return button;
    }
}
