import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Enlightened extends JDialog {
    class MyPanel extends JPanel {

        Color             c;
        private final int heigh;

        private final int width;

        public MyPanel() {
            this.heigh = Toolkit.getDefaultToolkit().getScreenSize().height;
            this.width = Toolkit.getDefaultToolkit().getScreenSize().width;
            this.c = Color.black;
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            setBackground(this.c);
            int random = new Random().nextInt(4);
            if (random == 0)
                g.drawImage(makeImageIcon("/images/Ingress_Green.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 - 256,
                        this.heigh / 2 - 256, this);
            else if (random == 1)
                g.drawImage(makeImageIcon("/images/Enlightened_Green.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 - 256,
                        this.heigh / 2 - 256, this);
            else if (random == 2)
                g.drawImage(makeImageIcon("/images/Resistance_Blue.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 - 256,
                        this.heigh / 2 - 256, this);
            else if (random == 3) {
                g.drawImage(makeImageIcon("/images/Enlightened_Green.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 - 640,
                        this.heigh / 2 - 128, this);
                g.drawImage(makeImageIcon("/images/Ingress_Dual.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 - 256,
                        this.heigh / 2 - 384, this);
                g.drawImage(makeImageIcon("/images/Resistance_Blue.png") //$NON-NLS-1$
                        .getImage(), this.width / 2 + 128,
                        this.heigh / 2 - 128, this);
            }

            g.dispose();
        }
    }

    MyPanel fullscreen = new MyPanel();

    public Enlightened() {
        add(this.fullscreen);
        setResizable(false);
        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setAlwaysOnTop(true);
        setUndecorated(true);
        setVisible(false);
        addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                //
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                dispose();

            }

            @Override
            public void keyTyped(KeyEvent arg0) {
                dispose();

            }
        });
        addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent arg0) {
                dispose();

            }

            @Override
            public void mouseEntered(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                //
            }

            @Override
            public void mouseReleased(MouseEvent arg0) {
                dispose();

            }
        });
        this.fullscreen.repaint();
    }

    public ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
