import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ListenerHandler extends MouseMotionAdapter implements
        MouseListener, KeyListener, ActionListener, ChangeListener {

    GUI2 gui;
    Point mouseclicked, windowlocation;

    public ListenerHandler(GUI2 mainGUI) {
        this.gui = mainGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command != null) if (command.equals("onTop")) {
            this.gui.setAlwaysOnTop(!this.gui.isAlwaysOnTop());
        }
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String name = e.getComponent().getName();
        if (name != null)
            if (name.equals("close"))
                System.exit(0);
            else if (name.equals("minimize"))
                this.gui.setState(Frame.ICONIFIED);
            else if (name.equals("large"))
                this.gui.setSize(new Dimension((int) (Toolkit
                        .getDefaultToolkit().getScreenSize().width * 0.95), 500));
            else if (name.equals("medium"))
                this.gui.setSize(new Dimension((int) (Toolkit
                        .getDefaultToolkit().getScreenSize().width * 0.66), 500));
            else if (name.equals("small"))
                this.gui.setSize(new Dimension((int) (Toolkit
                        .getDefaultToolkit().getScreenSize().width * 0.33), 500));

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.gui.setLocation(this.windowlocation.x
                + (e.getLocationOnScreen().x - this.mouseclicked.x),
                this.windowlocation.y
                        + (e.getLocationOnScreen().y - this.mouseclicked.y));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseclicked = e.getLocationOnScreen();
        this.windowlocation = this.gui.getLocation();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        // TODO Auto-generated method stub

    }

}
