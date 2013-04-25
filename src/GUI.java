import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Xenowar
 */

public class GUI extends JFrame implements ActionListener, ChangeListener,
        KeyListener {
    public static String removeSpaces(String input) {
        char[] withSpace = input.toCharArray();
        input = "";
        for (char element : withSpace) {
            if (element != ' ') {
                input += element;
            }
        }
        return input;
    }

    JPanel             mainpanel          = new JPanel(new GridBagLayout());
    JPanel             panel              = new JPanel(new GridBagLayout());
    JPanel             panel2             = new JPanel(new GridBagLayout());

    GridBagConstraints c                  = new GridBagConstraints();

    char[]             asciitable         = { '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', '\u2718', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9', '\u2718', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
            'W', 'X', 'Y', 'Z', '\u2718', '\u2718', '\u2718', '\u2718',
            '\u2718', '\u2718', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z'           };
    String[]           morse              = { ".-", // a
            "-...", // b
            "-.-.", // c
            "-..", // d
            ".", // e
            "..-.", // f
            "--.", // g
            "....", // h
            "..", // i
            ".---", // j
            "-.-", // k
            ".-..", // l
            "--", // m
            "-.", // n
            "---", // o
            ".--.", // p
            "--.-", // q
            ".-.", // r
            "...", // s
            "-", // t
            "..-", // u
            "...-", // v
            ".--", // w
            "-..-", // x
            "-.--", // y
            "--..", // z
            "-----",// 0
            ".----",// 1
            "..---",// 2
            "...--",// 3
            "....-",// 4
            ".....",// 5
            "-....",// 6
            "--...",// 7
            "---..",// 8
            "----." // 9
                                          };

    String[]           morseletters       = { "A", "B", "C", "D", "E", "F",
            "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "W", "X", "Y", "Z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9"           };

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
    JTextField         tf_lettertonumber  = new JTextField();

    JTextField         tf_l2n_start       = new JTextField();
    JSlider            sl_caesarian       = new JSlider(
                                                  SwingConstants.HORIZONTAL, 0,
                                                  25, 0);
    // JComboBox cb_caesarian = new JComboBox(caesar);
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

    public GUI() {
        this.tf_atbash.addKeyListener(this);
        setSize(new Dimension(780, 565));
        setResizable(false);
        setTitle("Decoder");
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
        this.tf_lettertonumber.setEditable(false);

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
        this.tf_lettertonumber.setFont(this.font);
        this.tf_l2n_start.setFont(this.font);

        add(this.mainpanel);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.mainpanel.add(new JLabel("<html><b>Code</b></html>"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.0;
        this.c.gridx = 1;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.mainpanel.add(this.alwaysontop, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.mainpanel.add(this.tf_code, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(0, 0, 0, 0);
        this.mainpanel.add(this.tabbedPane, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 2;
        this.c.insets = new Insets(5, 5, 5, 5);
        this.mainpanel.add(this.btn_generate, this.c);

        this.tabbedPane
                .addTab("Page 1 ", this.icon, this.panel,
                        "Reversed, Decimal to Ascii, Pattern to Binary, Morse, Caesarian Shift, Atbash");
        this.tabbedPane.addTab("Page 2 ", this.icon, this.panel2,
                "Vigenere Cipher");
        // tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

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

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.panel2.add(new JLabel("<html><b>Letters to Numbers</b></html>"),
                this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.01;
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel2.add(new JLabel("a = "), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 1;
        this.c.gridy = 4;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.panel2.add(this.tf_l2n_start, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        this.panel2.add(this.tf_lettertonumber, this.c);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        if (e.getSource().equals(this.btn_generate)) {
            reverse();
            patttobin();
            pattmorstoascii();
            caesarianShift();
            atbash();
            vinegere();
            lettertonumber();
            dectoasc();
        } else if (e.getSource().equals(this.alwaysontop)) {
            if (this.alwaysontop.isSelected()) {
                setAlwaysOnTop(true);
            } else {
                setAlwaysOnTop(false);
            }
        }

    }

    public void atbash() {
        char[] codeline = this.tf_code.getText().toCharArray();
        String result = "";
        for (int i = 0; i < codeline.length; i++) {
            if (codeline[i] >= 'a' && codeline[i] <= 'z') {
                codeline[i] = (char) ('z' - (codeline[i] - 'a'));
            } else if (codeline[i] >= 'A' && codeline[i] <= 'Z') {
                codeline[i] = (char) ('Z' - (codeline[i] - 'A'));
            }
            result += codeline[i];
        }
        this.tf_atbash.setText(result);

    }

    public void caesarianShift() {
        int shift = this.sl_caesarian.getValue();
        char[] codeline = this.tf_code.getText().toCharArray();
        String result = "";
        for (int i = 0; i < codeline.length; i++) {
            if (codeline[i] >= 'a' && codeline[i] <= 'z') {
                if (codeline[i] + shift > 'z')
                    codeline[i] = (char) (('a' - 1) + ((codeline[i] + shift) - 'z'));
                else codeline[i] = (char) (codeline[i] + shift);
            } else if (codeline[i] >= 'A' && codeline[i] <= 'Z') {
                if (codeline[i] + shift > 'Z')
                    codeline[i] = (char) (('A' - 1) + ((codeline[i] + shift) - 'Z'));
                else codeline[i] = (char) (codeline[i] + shift);
            }
        }
        for (char element : codeline) {
            result += element;
        }
        this.tf_caesarian.setText(result);
    }

    public void dectoasc() {
        char[] codeline = removeSpaces(this.tf_code.getText()).toCharArray();
        boolean check = true;
        String solution = "";

        for (char element : codeline) {
            if (element < '0' || element > '9') check = false;
        }

        if (check) {
            String[] parted = new String[(codeline.length + 2) / 3];

            for (int i = 0; i < parted.length; i++) {
                parted[i] = "";
            }
            for (int i = 0, j = 0; i < codeline.length; i++) {
                if (i == 0) {
                    parted[j] += codeline[i];
                } else if (i % 3 == 0) {
                    j++;
                    parted[j] += codeline[i];
                } else parted[j] += codeline[i];
            }

            for (String element : parted) {
                if (Integer.parseInt(element) < 123) {
                    solution += this.asciitable[Integer.parseInt(element)];
                } else solution += '\u2718';
            }
        }
        this.tf_dectoasc.setText(solution);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    public void lettertonumber() {
        char[] codeline = this.tf_code.getText().toCharArray();
        int start = Integer.parseInt(this.tf_l2n_start.getText());
        String result = "";
        for (char element : codeline) {
            if (Character.toLowerCase(element) >= 'a'
                    && Character.toLowerCase(element) <= 'z')
                result += (Character.toLowerCase(element) - 'a') + start;
        }
        this.tf_lettertonumber.setText(result);
    }

    public void pattmorstoascii() {
        if (!this.tf_short.getText().equals("")
                || !this.tf_long.getText().equals("")) {
            char[] dot = this.tf_short.getText().toCharArray();
            char[] line = this.tf_long.getText().toCharArray();
            char[] codeline = this.tf_code.getText().toCharArray();
            int spaces = 0;
            String result = "";

            for (char element : dot) {
                System.out.print(element);
            }
            System.out.println("");
            for (char element : line) {
                System.out.print(element);
            }
            System.out.println("");
            for (char element : codeline) {
                System.out.print(element);
            }
            System.out.println("");

            for (int i = 0; i < codeline.length; i++) {
                for (char element : dot) {
                    if (codeline[i] == element) codeline[i] = '\u00B7';
                }
                for (char element : line) {
                    if (codeline[i] == element) codeline[i] = '\u23AF';
                }
            }
            for (char element : codeline) {
                System.out.print(element);
            }
            System.out.println("");

            for (int i = 0; i < codeline.length; i++) {
                if (codeline[i] == '\u00B7')
                    codeline[i] = '.';
                else if (codeline[i] == '\u23AF')
                    codeline[i] = '-';
                else spaces++;
            }

            for (char element : codeline) {
                System.out.print(element);
            }
            System.out.println("");

            String[] parted = new String[spaces + 1];
            parted[0] = "";
            for (int i = 0, j = 0; i < codeline.length; i++) {
                if (codeline[i] != '.' && codeline[i] != '-') {
                    j++;
                    parted[j] = "";
                } else parted[j] += codeline[i];
            }

            for (String element : parted) {
                System.out.print(element + " ");
            }
            System.out.println("");

            for (String element : parted) {
                for (int j = 0; j < this.morse.length; j++) {
                    if (element.equals(this.morse[j])) {
                        result += this.morseletters[j];
                    }
                }
            }
            this.tf_pattmorstoascii.setText(result);
        }
    }

    public void patttobin() {
        if (!this.tf_zeros.getText().equals("")
                || !this.tf_ones.getText().equals("")) {
            char[] zeros = this.tf_zeros.getText().toCharArray();
            char[] ones = this.tf_ones.getText().toCharArray();
            char[] codeline = this.tf_code.getText().toCharArray();
            String result = "";
            for (int i = 0; i < codeline.length; i++) {
                boolean done = false;
                for (char zero : zeros) {
                    if (codeline[i] == zero) {
                        codeline[i] = '0';
                        done = true;
                        break;
                    }
                }
                if (!done) {
                    for (char one : ones) {
                        if (codeline[i] == one) {
                            codeline[i] = '1';
                            break;
                        }
                    }
                }
            }
            for (char element : codeline) {
                result += element;
            }
            this.tf_patttobin.setText(result);
        }
    }

    public void reverse() {
        char[] codeline = this.tf_code.getText().toCharArray();
        String reversed = "";
        for (int i = codeline.length - 1; i >= 0; i--) {
            reversed += codeline[i];
        }
        this.tf_reversed.setText(reversed);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        if (e.getSource().equals(this.sl_caesarian)) {
            caesarianShift();
        }
    }

    public void vinegere() {
        char[] passcode;
        if (!this.tf_vinegerepass.getText().equals(""))
            passcode = this.tf_vinegerepass.getText().toCharArray();
        else {
            passcode = new char[1];
            passcode[0] = 'a';
        }
        char[] codeline = this.tf_code.getText().toCharArray();
        String result = "";
        for (int i = 0, j = 0; i < codeline.length; i++) {
            if (codeline[i] >= 'a' && codeline[i] <= 'z') {
                if ((codeline[i] - Character.toLowerCase(passcode[j])) + 'a' < 'a') {
                    codeline[i] = (char) (('z' + 1) + (codeline[i] - Character
                            .toLowerCase(passcode[j])));
                } else codeline[i] = (char) (codeline[i] - (Character
                        .toLowerCase(passcode[j]) - 'a'));
            } else if (codeline[i] >= 'A' && codeline[i] <= 'Z') {
                if ((codeline[i] - Character.toUpperCase(passcode[j])) + 'A' < 'A') {
                    codeline[i] = (char) (('Z' + 1) + (codeline[i] - Character
                            .toUpperCase(passcode[j])));
                } else codeline[i] = (char) (codeline[i] - (Character
                        .toUpperCase(passcode[j]) - 'A'));
            }
            if (j == passcode.length - 1) {
                j = 0;
            } else {
                j++;
            }
        }
        for (char element : codeline) {
            result += element;
        }
        this.tf_vinegere.setText(result);

    }
}
