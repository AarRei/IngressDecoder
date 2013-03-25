import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CipherPanel2 extends JPanel {

    GridBagConstraints c               = new GridBagConstraints();
    Font               textfont        = new Font("Courier New", 1, 15);
    Color              yellowColor     = new Color(221, 186, 23);
    Font               mono            = new Font(Font.MONOSPACED, Font.PLAIN,
                                               12);
    ListenerHandler    listener;

    JTextField         tf_atbash       = new JTextField();
    JTextField         tf_vinegerepass = new JTextField();
    JTextField         tf_vinegere     = new JTextField();
    JTextField         tf_letter       = new JTextField("1");
    JTextField         tf_letterToNum  = new JTextField();

    JSlider            sl_caesarian    = new JSlider(SwingConstants.HORIZONTAL,
                                               0, 25, 0);

    public CipherPanel2(ListenerHandler listenerHandler) {
        super(new GridBagLayout());
        this.listener = listenerHandler;

        // fields
        // fields that are not supposed to be editable are not anymore
        this.tf_atbash.setEditable(false);
        this.tf_vinegere.setEditable(false);
        this.tf_letterToNum.setEditable(false);

        // set the font to monospaced
        this.tf_atbash.setFont(this.mono);
        this.tf_vinegere.setFont(this.mono);
        this.tf_vinegerepass.setFont(this.mono);
        this.tf_letter.setFont(this.mono);
        this.tf_letterToNum.setFont(this.mono);

        // set the design

        this.tf_atbash.setBackground(Color.black);
        this.tf_atbash.setForeground(this.yellowColor);
        this.tf_vinegere.setBackground(Color.black);
        this.tf_vinegere.setForeground(this.yellowColor);
        this.tf_vinegerepass.setBackground(Color.black);
        this.tf_vinegerepass.setForeground(this.yellowColor);
        this.tf_letter.setBackground(Color.black);
        this.tf_letter.setForeground(this.yellowColor);
        this.tf_letterToNum.setBackground(Color.black);
        this.tf_letterToNum.setForeground(this.yellowColor);

        // add containers to panel
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Atbash"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 3, 5);
        add(this.tf_atbash, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Vigenere Cipher"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel("Passphrase:"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 1;
        this.c.gridy = 3;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_vinegerepass.setName("vignere");
        this.tf_vinegerepass.addCaretListener(this.listener);
        add(this.tf_vinegerepass, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_vinegere, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel("Letter to Number"), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 6;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel("a ="), this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 1;
        this.c.gridy = 6;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_letter.setName("letter");
        this.tf_letter.addCaretListener(this.listener);
        add(this.tf_letter, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 7;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_letterToNum, this.c);

        // general panel settings
        setBackground(Color.black);
    }

}
