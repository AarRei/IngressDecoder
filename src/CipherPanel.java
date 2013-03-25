import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CipherPanel extends JPanel {

    GridBagConstraints c                  = new GridBagConstraints();
    Font               textfont           = new Font("Courier New", 1, 15);
    Color              yellowColor        = new Color(221, 186, 23);
    Font               mono               = new Font(Font.MONOSPACED,
                                                  Font.PLAIN, 12);
    ListenerHandler    listener;

    JTextField         tf_reversed        = new JTextField();
    JTextField         tf_zeros           = new JTextField();
    JTextField         tf_ones            = new JTextField();
    JTextField         tf_long            = new JTextField();
    JTextField         tf_short           = new JTextField();
    JTextField         tf_patttobin       = new JTextField();
    JTextField         tf_pattmorstoascii = new JTextField();
    JTextField         tf_caesarian       = new JTextField();

    JSlider            sl_caesarian       = new JSlider(
                                                  SwingConstants.HORIZONTAL, 0,
                                                  25, 0);

    public CipherPanel(ListenerHandler listenerHandler) {
        super(new GridBagLayout());
        this.listener = listenerHandler;

        // fields
        // fields that are not supposed to be editable are not anymore
        this.tf_reversed.setEditable(false);
        this.tf_patttobin.setEditable(false);
        this.tf_pattmorstoascii.setEditable(false);
        this.tf_caesarian.setEditable(false);
        // this.tf_dectoasc.setEditable(false);

        // set the font to monospaced
        this.tf_reversed.setFont(this.mono);
        this.tf_zeros.setFont(this.mono);
        this.tf_ones.setFont(this.mono);
        this.tf_patttobin.setFont(this.mono);
        this.tf_short.setFont(this.mono);
        this.tf_long.setFont(this.mono);
        this.tf_pattmorstoascii.setFont(this.mono);
        this.tf_caesarian.setFont(this.mono);
        // this.tf_code.setFont(this.font);
        // this.tf_dectoasc.setFont(this.font);

        this.sl_caesarian.setFont(this.textfont);

        // set the design

        this.tf_reversed.setBackground(Color.black);
        this.tf_reversed.setForeground(this.yellowColor);
        this.tf_zeros.setBackground(Color.black);
        this.tf_zeros.setForeground(this.yellowColor);
        this.tf_ones.setBackground(Color.black);
        this.tf_ones.setForeground(this.yellowColor);
        this.tf_patttobin.setBackground(Color.black);
        this.tf_patttobin.setForeground(this.yellowColor);
        this.tf_short.setBackground(Color.black);
        this.tf_short.setForeground(this.yellowColor);
        this.tf_long.setBackground(Color.black);
        this.tf_long.setForeground(this.yellowColor);
        this.tf_pattmorstoascii.setBackground(Color.black);
        this.tf_pattmorstoascii.setForeground(this.yellowColor);
        this.tf_caesarian.setBackground(Color.black);
        this.tf_caesarian.setForeground(this.yellowColor);

        // slider settings
        this.sl_caesarian.addChangeListener(this.listener);
        this.sl_caesarian.setMajorTickSpacing(5);
        this.sl_caesarian.setMinorTickSpacing(1);
        this.sl_caesarian.setPaintTicks(true);
        this.sl_caesarian.setPaintLabels(true);
        this.sl_caesarian.setBackground(Color.black);
        this.sl_caesarian.setForeground(this.yellowColor);

        // this.tf_code.setFont(this.font);
        // this.tf_dectoasc.setFont(this.font);

        // add containers to panel
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Reversed"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_reversed, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        // this.c.weightx = 1.0;
        // this.c.gridx = 0;
        // this.c.gridy = 4;
        // this.c.gridwidth = 4;
        // this.c.insets = new Insets(0, 5, 0, 5);
        // add(new JLabel("<html><b>Decimal to Ascii</b></html>"), this.c);
        //
        // this.c.fill = GridBagConstraints.HORIZONTAL;
        // this.c.weightx = 1.0;
        // this.c.gridx = 0;
        // this.c.gridy = 5;
        // this.c.gridwidth = 4;
        // this.c.insets = new Insets(0, 5, 5, 5);
        // this.panel.add(this.tf_dectoasc, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 6;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Pattern to binary"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 0;
        this.c.gridy = 7;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(GUI2.makeTextLabel("0:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 1;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_zeros, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 2;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(GUI2.makeTextLabel("1:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 3;
        this.c.gridy = 7;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_ones, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 8;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_patttobin, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 9;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Morsepattern to Ascii"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 0;
        this.c.gridy = 10;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(GUI2.makeTextLabel("short:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 1;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_short, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.02;
        this.c.gridx = 2;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(GUI2.makeTextLabel("long:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.48;
        this.c.gridx = 3;
        this.c.gridy = 10;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_long, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 11;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_pattmorstoascii, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 12;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Caesarian Shift"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 13;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel("Shift:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.1;
        this.c.gridx = 1;
        this.c.gridy = 13;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(this.sl_caesarian, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 14;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_caesarian, this.c);

        // general panel settings
        setBackground(Color.black);
    }

}
