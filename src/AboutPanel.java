import java.awt.Color;

import javax.swing.JPanel;

public class AboutPanel extends JPanel {

    ListenerHandler listener;

    public AboutPanel(ListenerHandler listenerHandler) {
        this.listener = listenerHandler;
        setBackground(Color.black);
    }
}
