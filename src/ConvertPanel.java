import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConvertPanel extends JPanel {

    GridBagConstraints c           = new GridBagConstraints();
    Font               textfont    = new Font("Courier New", 1, 15);
    Color              yellowColor = new Color(221, 186, 23);
    Font               mono        = new Font(Font.MONOSPACED, Font.PLAIN, 12);
    ListenerHandler    listener;

    JTextField         tf_dectoasc = new JTextField();
    JTextField         tf_text     = new JTextField();
    JTextField         tf_bin      = new JTextField();
    JTextField         tf_hex      = new JTextField();
    JTextField         tf_base64   = new JTextField();
    JTextField         tf_ascii    = new JTextField();

    JButton            btn_text    = new JButton("Text");
    JButton            btn_bin     = new JButton("Binary");
    JButton            btn_hex     = new JButton("Hex");
    JButton            btn_base64  = new JButton("Base64");
    JButton            btn_ascii   = new JButton("ASCII Dec/Char");

    public ConvertPanel(ListenerHandler listenerHandler) {
        super(new GridBagLayout());
        this.listener = listenerHandler;

        // fields
        // fields that are not supposed to be editable are not anymore
        this.tf_dectoasc.setEditable(false);
        this.tf_text.setEditable(false);
        this.tf_bin.setEditable(false);
        this.tf_hex.setEditable(false);
        this.tf_base64.setEditable(false);
        this.tf_ascii.setEditable(false);

        // set the font to monospaced
        this.tf_dectoasc.setFont(this.mono);
        this.tf_text.setFont(this.mono);
        this.tf_bin.setFont(this.mono);
        this.tf_hex.setFont(this.mono);
        this.tf_base64.setFont(this.mono);
        this.tf_ascii.setFont(this.mono);

        this.btn_text.setFont(this.mono);
        this.btn_bin.setFont(this.mono);
        this.btn_hex.setFont(this.mono);
        this.btn_base64.setFont(this.mono);
        this.btn_ascii.setFont(this.mono);

        // set the design

        this.tf_dectoasc.setBackground(Color.black);
        this.tf_dectoasc.setForeground(this.yellowColor);
        this.tf_text.setBackground(Color.black);
        this.tf_text.setForeground(this.yellowColor);
        this.tf_bin.setBackground(Color.black);
        this.tf_bin.setForeground(this.yellowColor);
        this.tf_hex.setBackground(Color.black);
        this.tf_hex.setForeground(this.yellowColor);
        this.tf_base64.setBackground(Color.black);
        this.tf_base64.setForeground(this.yellowColor);
        this.tf_ascii.setBackground(Color.black);
        this.tf_ascii.setForeground(this.yellowColor);

        this.btn_text.setBackground(Color.black);
        this.btn_text.setForeground(this.yellowColor);
        this.btn_bin.setBackground(Color.black);
        this.btn_bin.setForeground(this.yellowColor);
        this.btn_hex.setBackground(Color.black);
        this.btn_hex.setForeground(this.yellowColor);
        this.btn_base64.setBackground(Color.black);
        this.btn_base64.setForeground(this.yellowColor);
        this.btn_ascii.setBackground(Color.black);
        this.btn_ascii.setForeground(this.yellowColor);

        // add containers to panel

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(this.btn_text, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 1;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(this.btn_bin, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 2;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(this.btn_hex, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 3;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(this.btn_base64, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 4;
        this.c.gridy = 0;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(this.btn_ascii, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Text:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_text, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Binary:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_bin, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Hex:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 6;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_hex, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 7;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Base64:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 8;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_base64, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 9;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("ASCII Dec/Char:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 10;
        this.c.gridwidth = 5;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_ascii, this.c);

        // general panel settings
        setBackground(Color.black);
    }

}
