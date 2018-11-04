package tokoemas;

import java.awt.Dimension;
import javafx.scene.Node;
import javax.swing.JFrame;
import javax.swing.JSplitPane;
import panels.*;

/**
 *
 * @author Xenon
 */
public class MyFrame extends JFrame {
    
    LeftMenu menu;
    JSplitPane splitPane;
    Transaksi transaksiPanel;
    
    MyFrame(){
        splitPane = new JSplitPane();
        menu = new LeftMenu(splitPane);
        transaksiPanel = new Transaksi(); //Ganti dengan Dashboard!
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(splitPane);
        setPreferredSize(new Dimension(1280, 720));
        
        splitPane.setDividerLocation(300);
        splitPane.setLeftComponent(menu);
        splitPane.setRightComponent(transaksiPanel);
        splitPane.remove(splitPane.getComponent(0));

        pack();
    }
    
    public static void main(String[] args) {
        new MyFrame().setVisible(true);
    }
}
