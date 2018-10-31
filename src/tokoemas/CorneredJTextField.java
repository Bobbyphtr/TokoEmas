package tokoemas;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Xenon
 */
public class CorneredJTextField extends JTextField{
    
    private Shape shape;
    public CorneredJTextField(int size) {
        super(size);
        setOpaque(false); // As suggested by @AVD in comment
    }
    protected void paintComponent(Graphics g) {
         g.setColor(getBackground());
         g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
         super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10)); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    public boolean contains(int x, int y) {
         if (shape == null || !shape.getBounds().equals(getBounds())) {
             shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 10, 10);
         }
         return shape.contains(x, y);
    }
}
