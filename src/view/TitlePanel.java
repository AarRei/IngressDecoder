package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Handler;

public class TitlePanel extends JPanel {

    private final JLabel globe;
    private boolean globerHovered = false;

    public TitlePanel(Handler mlt) {
        super();

        //set LayoutMng
        this.setLayout(new MigLayout("fill"));
        this.setBackground(Color.black);

        //setLayout
        this.add(new JLabel(makeImageIcon("/images/Ingress_Dual_small.png")));

        JLabel title = new JLabel("Ingress Cipher Tool");
        title.setForeground(GUI3.LIME_GREEN);
        title.setFont(GUI3.INGRESS_FONT.deriveFont(25f));
        title.setName("TitleText");
        title.addMouseListener(mlt);

        this.add(title, "growx, push");

        globe = new JLabel(makeImageIcon("/images/globe_small.png"));
        globe.setName("globeMenu");
        globe.addMouseListener(mlt);
        globe.setToolTipText("About us");

        this.add(globe);
    }

    ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }

    public void hoverGlobe() {
        if(!globerHovered) globe.setIcon(makeImageIcon("/images/globe_hover_small.png"));
        else globe.setIcon(makeImageIcon("/images/globe_small.png"));
        globerHovered = !globerHovered;
    }
}
