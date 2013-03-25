import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GUI2 extends JFrame {

    public static JLabel makeTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Courier New", 1, 15));
        label.setForeground(new Color(221, 186, 23));
        return label;
    }

    ListenerHandler    listener;
    JPanel             mainPanel, innerPane1, innerPane2;
    JTabbedPane        tabbedPane;
    JCheckBox          alwaysontop;
    JTextField         tf_code;
    ColoredMenuBar     menubar;
    JButton            btn_generate;
    GridBagConstraints c           = new GridBagConstraints();

    Font               textfont    = new Font("Courier New", 1, 16);

    Color              yellowColor = new Color(221, 186, 23);

    Font               mono        = new Font(Font.MONOSPACED, Font.PLAIN, 14);

    public GUI2() {
        this.listener = new ListenerHandler(this);
    }

    public void initGUI() {

        // init main panel components
        this.mainPanel = new JPanel(new GridBagLayout());
        this.tabbedPane = new JTabbedPane();

        this.mainPanel.setBackground(Color.black);

        this.tabbedPane.setBackground(Color.black);
        this.tabbedPane.setForeground(this.yellowColor);
        this.tabbedPane.setFont(this.textfont);
        this.tabbedPane.setUI(new CustomTabbedPaneUI());
        this.tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

        // menu bar items
        JLabel close = new JLabel(makeImageIcon("/images/close.png"));
        close.setName("close");
        close.addMouseListener(this.listener);
        JLabel minimize = new JLabel(makeImageIcon("/images/minimize.png"));
        minimize.setName("minimize");
        minimize.addMouseListener(this.listener);
        JLabel large = new JLabel(makeImageIcon("/images/large.png"));
        large.setName("large");
        large.addMouseListener(this.listener);
        JLabel medium = new JLabel(makeImageIcon("/images/medium.png"));
        medium.setName("medium");
        medium.addMouseListener(this.listener);
        JLabel small = new JLabel(makeImageIcon("/images/small.png"));
        small.setName("small");
        small.addMouseListener(this.listener);

        JLabel ingressIcon = new JLabel(
                makeImageIcon("/images/Ingress_Logo_Middle.png"));

        JLabel title = new JLabel("Ingress Decoder");
        title.setFont(new Font("Courier New", 1, 25));
        title.setForeground(new Color(221, 186, 23));

        // init menubar
        this.menubar = new ColoredMenuBar();
        this.menubar.addMouseMotionListener(this.listener);
        this.menubar.addMouseListener(this.listener);
        this.menubar.setBorder(new EmptyBorder(0, 0, 0, 0));

        this.menubar.add(ingressIcon);
        this.menubar.add(Box.createHorizontalStrut(10));
        this.menubar.add(title);
        this.menubar.add(Box.createHorizontalGlue());
        this.menubar.add(small);
        this.menubar.add(medium);
        this.menubar.add(large);
        this.menubar.add(minimize);
        this.menubar.add(close);

        // adding pannels to tabbed pain
        this.tabbedPane
                .addTab("Cipher", makeImageIcon("/images/Ingress_Logo.png"),
                        new CipherPanel(this.listener),
                        "Reversed, Decimal to Ascii, Pattern to Binary, Morse, Caesarian Shift");
        this.tabbedPane.addTab("Cipher 2",
                makeImageIcon("/images/Ingress_Logo.png"), new CipherPanel2(
                        this.listener), "Atbash, Vigenere Key");
        this.tabbedPane.addTab("Converter",
                makeImageIcon("/images/Ingress_Logo.png"), new ConvertPanel(
                        this.listener), "Dec2ASCII");
        this.tabbedPane.addTab("About us",
                makeImageIcon("/images/enlightened.png"), new AboutPanel(
                        this.listener), "About us");

        // adding components to mainpanel
        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.mainPanel.add(makeTextLabel("Code"), this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 0.0;
        this.c.gridx = 1;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.alwaysontop = new JCheckBox("Always on top");
        this.alwaysontop.setFont(this.textfont);
        this.alwaysontop.setForeground(this.yellowColor);
        this.alwaysontop.setActionCommand("onTop");
        this.alwaysontop.addActionListener(this.listener);
        this.mainPanel.add(this.alwaysontop, this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.tf_code = new JTextField();
        this.tf_code.setBackground(Color.black);
        this.tf_code.setFont(this.mono);
        this.tf_code.setForeground(this.yellowColor);
        this.mainPanel.add(this.tf_code, this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 0, 0, 0);
        this.mainPanel.add(this.tabbedPane, this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(5, 5, 5, 5);
        this.btn_generate = new JButton("Generate");
        this.btn_generate.setBackground(Color.black);
        this.btn_generate.setFont(this.textfont);
        this.btn_generate.setForeground(this.yellowColor);
        this.mainPanel.add(this.btn_generate, this.c);

        // adding components to frame
        add(this.menubar, BorderLayout.NORTH);
        add(this.mainPanel, BorderLayout.CENTER);

        // general frame settings
        setSize(new Dimension((int) (Toolkit.getDefaultToolkit()
                .getScreenSize().width * 0.66), 500));
        setIconImage(makeImageIcon("/images/Ingress_Logo_Middle.png")
                .getImage());
        setTitle("Decoder");
        setUndecorated(true);
        setVisible(true);
    }

    private ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
