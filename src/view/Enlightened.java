package view;

import org.newdawn.easyogg.OggClip;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Enlightened extends JDialog {

    private OggClip clip;

    class MyPanel extends JPanel {

        final Color c;

        private       boolean clipplayed;
        private final int     random;
        private       Image   image;


        public MyPanel() {
            this.c = Color.black;
            random = new Random().nextInt(4);
            clipplayed = false;
        }

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);
            setBackground(this.c);
            try {
                switch(random) {
                    case 0:
                        image = makeImageIcon("/images/Ingress_Green.png").getImage();
                        g.drawImage(image, (this.getWidth() - image.getWidth(null)) / 2,
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        clip = new OggClip("sounds/speech_faction_choice_enlightened_alt.ogg");
                        break;
                    case 1:
                        image = makeImageIcon("/images/Enlightened_Green.png").getImage();
                        g.drawImage(image, (this.getWidth() - image.getWidth(null)) / 2,
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        clip = new OggClip("sounds/speech_faction_choice_enlightened.ogg");
                        break;
                    case 2:
                        image = makeImageIcon("/images/Resistance_Blue.png").getImage();
                        g.drawImage(image, (this.getWidth() - image.getWidth(null)) / 2,
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        clip = new OggClip("sounds/speech_faction_choice_humanist_alt.ogg");
                        break;
                    default:
                        image = makeImageIcon("/images/Ingress_Dual.png").getImage();
                        g.drawImage(image, ((this.getWidth() - image.getWidth(null)) / 2),
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        int gap = image.getWidth(null) / 2 + 150;
                        image = makeImageIcon("/images/Enlightened_Green.png").getImage();
                        g.drawImage(image, ((this.getWidth() - image.getWidth(null)) / 2) - gap,
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        image = makeImageIcon("/images/Resistance_Blue.png").getImage();
                        g.drawImage(image, ((this.getWidth() - image.getWidth(null)) / 2) + gap,
                                    (this.getHeight() - image.getHeight(null)) / 2, this);
                        clip = new OggClip("sounds/ada_intro.ogg");
                        break;
                }
            } catch(IOException ignored) {

            }
            if(clip != null && !clipplayed) clip.play();
            clipplayed = true;
            g.dispose();
        }
    }

    public Enlightened() {
        MyPanel fullscreen = new MyPanel();
        add(fullscreen);
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
        fullscreen.repaint();
    }

    ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
