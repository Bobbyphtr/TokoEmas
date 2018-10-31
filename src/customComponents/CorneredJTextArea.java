package customComponents;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

/**
 *
 * @author Xenon
 */
public class CorneredJTextArea extends JTextArea {

    private Shape shape;

    public CorneredJTextArea() {
        setOpaque(false); // As suggested by @AVD in comment
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        super.paintComponent(g);
    }

    @Override
    public void setBorder(Border border) {
        super.setBorder(new RoundBorder(10)); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSelectionColor(Color color) {
        super.setSelectionColor(new java.awt.Color(255, 153, 0)); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }
        return shape.contains(x, y);
    }
}
