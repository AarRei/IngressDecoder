import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class NewGUI extends JFrame implements ActionListener, ChangeListener,
        KeyListener {
    JPanel             mainpanel          = new JPanel(new GridBagLayout());
    JPanel             panel              = new JPanel(new GridBagLayout());
    JPanel             panel2             = new JPanel(new GridBagLayout());
    JScrollPane        scrollpane         = new JScrollPane();
    JScrollPane        mainscrollpane     = new JScrollPane();
    GridBagConstraints c                  = new GridBagConstraints();

    JTextField         tf_code            = new JTextField();

    JTextField         tf_reversed        = new JTextField();
    JTextField         tf_dectoasc        = new JTextField();
    JTextField         tf_zeros           = new JTextField();
    JTextField         tf_ones            = new JTextField();
    JTextField         tf_patttobin       = new JTextField();
    JTextField         tf_short           = new JTextField();
    JTextField         tf_long            = new JTextField();
    JTextField         tf_pattmorstoascii = new JTextField();
    JTextField         tf_caesarian       = new JTextField();
    JTextField         tf_atbash          = new JTextField();

    JTextField         tf_vinegere        = new JTextField();
    JTextField         tf_vinegerepass    = new JTextField();

    JSlider            sl_caesarian       = new JSlider(
                                                  SwingConstants.HORIZONTAL, 0,
                                                  25, 0);
    JButton            btn_generate       = new JButton("Generate");
    JCheckBox          alwaysontop        = new JCheckBox("Always on top");
    JTabbedPane        tabbedPane         = new JTabbedPane();
    java.net.URL       imgURL             = getClass().getResource(
                                                  "/images/Ingress_Logo.png");
    ImageIcon          icon               = new ImageIcon(this.imgURL);
    java.net.URL       imgURL2            = getClass()
                                                  .getResource(
                                                          "/images/Ingress_Logo_Middle.png");
    ImageIcon          icon2              = new ImageIcon(this.imgURL);
    String             mop                = "";
    Font               font               = new Font(Font.MONOSPACED,
                                                  Font.PLAIN, 12);

    public NewGUI() {
        this.tf_atbash.addKeyListener(this);
        setSize(new Dimension(780, 565));
        // setResizable(false);
        setTitle("Decoder");
        this.mainpanel.setBackground(new Color(125, 14, 31));
        setIconImage(this.icon2.getImage());
        this.sl_caesarian.addChangeListener(this);
        this.sl_caesarian.setMajorTickSpacing(5);
        this.sl_caesarian.setMinorTickSpacing(1);
        this.sl_caesarian.setPaintTicks(true);
        this.sl_caesarian.setPaintLabels(true);
        this.btn_generate.addActionListener(this);
        this.alwaysontop.addActionListener(this);
        this.tf_code.addKeyListener(this);

        // fields that are not supposed to be editable are not anymore
        this.tf_reversed.setEditable(false);
        this.tf_reversed.setEditable(false);
        this.tf_dectoasc.setEditable(false);
        this.tf_patttobin.setEditable(false);
        this.tf_pattmorstoascii.setEditable(false);
        this.tf_caesarian.setEditable(false);
        this.tf_atbash.setEditable(false);
        this.tf_vinegere.setEditable(false);

        // set the font to monospaced
        this.tf_code.setFont(this.font);
        this.tf_reversed.setFont(this.font);
        this.tf_dectoasc.setFont(this.font);
        this.tf_zeros.setFont(this.font);
        this.tf_ones.setFont(this.font);
        this.tf_patttobin.setFont(this.font);
        this.tf_short.setFont(this.font);
        this.tf_long.setFont(this.font);
        this.tf_pattmorstoascii.setFont(this.font);
        this.tf_caesarian.setFont(this.font);
        this.tf_atbash.setFont(this.font);
        this.tf_vinegere.setFont(this.font);
        this.tf_vinegerepass.setFont(this.font);

        add(this.mainpanel);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.mainpanel.add(new JLabel("<html><b>Code</b></html>"), this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 0.0;
        this.c.gridx = 1;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.mainpanel.add(this.alwaysontop, this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.mainpanel.add(this.tf_code, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 0, 0, 0);
        this.mainpanel.add(this.tabbedPane, this.c);

        this.c.fill = GridBagConstraints.BOTH;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(5, 5, 5, 5);
        this.mainpanel.add(this.btn_generate, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Reversed</b></html>"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_reversed, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Decimal to Ascii</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_dectoasc, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 6;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Pattern to binary</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 0;
        this.c.gridy = 7;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(new JLabel("0:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 1;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_zeros, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 2;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(new JLabel("1:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 3;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_ones, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 8;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_patttobin, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 9;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Morsepattern to Ascii</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 0;
        this.c.gridy = 10;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(new JLabel("short:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 1;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_short, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 2;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(new JLabel("long:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 3;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_long, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 11;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_pattmorstoascii, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 12;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Caesarian Shift</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 13;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel.add(new JLabel("Shift:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.1;
        this.c.gridx = 1;
        this.c.gridy = 13;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel.add(this.sl_caesarian, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 14;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel.add(this.tf_caesarian, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 15;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel.add(new JLabel("<html><b>Atbash</b></html>"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 16;
        this.c.insets = new Insets(0, 5, 3, 5);
        this.panel.add(this.tf_atbash, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel2.add(new JLabel("<html><b>Vigenere Cipher</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel2.add(new JLabel("Passphrase:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 1;
        this.c.gridy = 1;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel2.add(this.tf_vinegerepass, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel2.add(this.tf_vinegere, this.c);

        this.panel.setPreferredSize(new Dimension(200, 400));

        this.tabbedPane
                .addTab("Page 1 ", this.icon, makeScrollPanel(this.panel),
                        "Reversed, Decimal to Ascii, Pattern to Binary, Morse, Caesarian Shift, Atbash");
        this.tabbedPane.addTab("Page 2 ", this.icon,
                makeScrollPanel(this.panel2), "Vigenere Cipher");

        this.tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
        // tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        setVisible(true);
        validate();
        repaint();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource().equals(this.btn_generate)) {
            // TODO
            // reverse();
            // patttobin();
            // pattmorstoascii();
            // caesarianShift();
            // atbash();
            // dectoasc();
        } else if (e.getSource().equals(this.alwaysontop)) {
            if (this.alwaysontop.isSelected()) {
                setAlwaysOnTop(true);
            } else {
                setAlwaysOnTop(false);
            }
        }

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (this.mop.equals("mo")) {
            if (e.getKeyCode() == KeyEvent.VK_P)
                this.mop += "p";
            else this.mop = "";
        } else if (this.mop.equals("m")) {
            if (e.getKeyCode() == KeyEvent.VK_O)
                this.mop += "o";
            else this.mop = "";
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            this.mop += "m";
            System.out.println("m");
        }

        if (this.mop.equals("mop")) setResizable(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource().equals(this.sl_caesarian)) {
            // TODO
            // caesarianShift();
        }
    }

    protected JComponent makeScrollPanel(JPanel contentpanel) {
        JPanel panel = new JPanel(false);
        contentpanel.setPreferredSize(new Dimension(400, 400));
        // contentpanel.setMinimumSize(new Dimension(100, 300));
        JScrollPane scroll = new JScrollPane(contentpanel);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(scroll);
        // panel.setPreferredSize(new Dimension(500, 400));
        panel.setMinimumSize(new Dimension(100, 300));
        return panel;
    }
}
