import java.awt.Color;

import javax.swing.JPanel;

public class AboutPanel extends JPanel {

    private static final long serialVersionUID = 766490351950584347L;

    ListenerHandler           listener;

    public AboutPanel(ListenerHandler listenerHandler) {
        this.listener = listenerHandler;
        setBackground(Color.black);
    }
}
