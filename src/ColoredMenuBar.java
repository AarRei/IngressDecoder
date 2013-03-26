import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JMenuBar;

public class ColoredMenuBar extends JMenuBar {

    private static final long serialVersionUID = 7340663276533777634L;

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(34, 34, 34));
        g2d.fillRect(0, 0, getWidth() - 1, getHeight() - 1);

    }

}