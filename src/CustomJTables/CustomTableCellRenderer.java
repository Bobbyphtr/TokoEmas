/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomJTables;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ysuta
 */
public class CustomTableCellRenderer extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
        if (row % 2 == 0) {
            setBackground(Color.RED);
            setForeground(Color.BLACK);
        }
        else {
            setBackground(Color.GREEN);
            setForeground(Color.BLACK);
        }
        
        return this;
    }
    
}
