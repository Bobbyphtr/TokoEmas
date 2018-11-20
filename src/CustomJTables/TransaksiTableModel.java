/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomJTables;

import java.util.Vector;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ysuta
 */
public class TransaksiTableModel extends DefaultTableModel{
    
    private String[] COLUMN_NAMES;
    private final Class<?>[] COLUMN_TYPES = new Class<?>[]{Integer.class, String.class, Integer.class, Integer.class, String.class, String.class, JButton.class};
    
    private Vector data;
    
    public TransaksiTableModel(Vector data, Vector columnNames) {
        super(data, columnNames);
        COLUMN_NAMES = new String[]{"ID_Product", "Berat(gr)", "Karat", "Tipe", "Deskripsi", "Aksi"};
        this.data = data;
    }
    
    public TransaksiTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        COLUMN_NAMES = new String[]{"ID_Product", "Berat(gr)", "Karat", "Tipe", "Deskripsi", "Aksi"};
        this.data = super.getDataVector();
    }
    
//
//    @Override
//    public int getColumnCount() {
//        return COLUMN_NAMES.length;
//    }
    
    @Override public Class<?> getColumnClass(int columnIndex) {
        return COLUMN_TYPES[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex == COLUMN_NAMES.length-1) {
            JButton button = new JButton("Tambah");
            button.addActionListener((v) ->{
                System.out.println("DO nothing yet!");
            });
        }
        Vector rowVector = (Vector)dataVector.elementAt(rowIndex);
        return rowVector.elementAt(columnIndex);
    }
    
}
