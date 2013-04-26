import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class CipherPanel2 extends JPanel {

    private static final long serialVersionUID = -5796174709710193158L;

    protected static MaskFormatter createFormatter(String s) {
        MaskFormatter formatter = null;
        try {
            for (int i = 0; i < 7; i++)
                s += s;
            formatter = new MaskFormatter(s);
        } catch (java.text.ParseException exc) {
            System.exit(-1);
        }
        return formatter;
    }

    GridBagConstraints  c                      = new GridBagConstraints();
    Font                textfont               = new Font("Courier New", 1, 15);                              //$NON-NLS-1$
    Color               yellowColor            = new Color(0, 205, 106);
    Font                mono                   = new Font(Font.MONOSPACED,
                                                       Font.PLAIN, 12);

    ListenerHandler     listener;
    JTextField          tf_atbash              = new JTextField();
    // JTextField tf_vinegerepass = new JTextField();
    JTextField          tf_vinegere            = new JTextField();
    // JTextField tf_vinegereautokeypass = new JTextField();
    JTextField          tf_vinegereautokey     = new JTextField();
    JTextField          tf_letter              = new JTextField("1");                                         //$NON-NLS-1$

    JTextField          tf_letterToNum         = new JTextField();
    JFormattedTextField tf_vinegerepass        = new JFormattedTextField(
                                                       createFormatter("L"));                                 //$NON-NLS-1$

    JFormattedTextField tf_vinegereautokeypass = new JFormattedTextField(
                                                       createFormatter("L"));                                 //$NON-NLS-1$

    JCheckBox           cb_NumToLetter         = new JCheckBox(
                                                       Messages.getString("CipherPanel2.Label_NumberLetter")); //$NON-NLS-1$

    JSlider             sl_caesarian           = new JSlider(
                                                       SwingConstants.HORIZONTAL,
                                                       0, 25, 0);

    public CipherPanel2(ListenerHandler listenerHandler) {
        super(new GridBagLayout());
        this.listener = listenerHandler;

        // fields
        // fields that are not supposed to be editable are not anymore
        this.tf_atbash.setEditable(false);
        this.tf_vinegere.setEditable(false);
        this.tf_vinegereautokey.setEditable(false);
        this.tf_letterToNum.setEditable(false);

        // set the font to monospaced
        this.tf_atbash.setFont(this.mono);
        this.tf_vinegere.setFont(this.mono);
        this.tf_vinegereautokey.setFont(this.mono);
        this.tf_vinegerepass.setFont(this.mono);
        this.tf_vinegereautokeypass.setFont(this.mono);
        this.tf_letter.setFont(this.mono);
        this.tf_letterToNum.setFont(this.mono);
        this.cb_NumToLetter.setFont(this.mono);

        // set the design

        this.tf_atbash.setBackground(Color.black);
        this.tf_atbash.setForeground(this.yellowColor);
        this.tf_vinegere.setBackground(Color.black);
        this.tf_vinegere.setForeground(this.yellowColor);
        this.tf_vinegerepass.setBackground(Color.black);
        this.tf_vinegerepass.setForeground(this.yellowColor);
        this.tf_vinegereautokey.setBackground(Color.black);
        this.tf_vinegereautokey.setForeground(this.yellowColor);
        this.tf_vinegereautokeypass.setBackground(Color.black);
        this.tf_vinegereautokeypass.setForeground(this.yellowColor);
        this.tf_letter.setBackground(Color.black);
        this.tf_letter.setForeground(this.yellowColor);
        this.tf_letterToNum.setBackground(Color.black);
        this.tf_letterToNum.setForeground(this.yellowColor);
        this.cb_NumToLetter.setBackground(Color.black);
        this.cb_NumToLetter.setForeground(this.yellowColor);

        // add containers to panel
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel(Messages.getString("CipherPanel2.Label_Atbash")), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 3, 5);
        add(this.tf_atbash, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel(Messages
                .getString("CipherPanel2.Label_Vigenere")), this.c); //$NON-NLS-1$

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.1;
        this.c.gridx = 0;
        this.c.gridy = 3;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel(Messages
                .getString("CipherPanel2.Label_Vigenere_Passphrase")), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 1;
        this.c.gridy = 3;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_vinegerepass.setName("vignere"); //$NON-NLS-1$
        this.tf_vinegerepass.addCaretListener(this.listener);
        add(this.tf_vinegerepass, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 4;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_vinegere, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 5;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel(Messages
                .getString("CipherPanel2.Label_VigenereAutokey")), this.c); //$NON-NLS-1$

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.1;
        this.c.gridx = 0;
        this.c.gridy = 6;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel(Messages
                .getString("CipherPanel2.Label_VigenereAutokey_Passphrase")), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 1;
        this.c.gridy = 6;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_vinegereautokeypass.setName("vignere_autokey"); //$NON-NLS-1$
        this.tf_vinegereautokeypass.addCaretListener(this.listener);
        add(this.tf_vinegereautokeypass, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 7;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_vinegereautokey, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 8;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel(Messages
                .getString("CipherPanel2.Label_LetterToNumber")), this.c); //$NON-NLS-1$

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 1;
        this.c.gridy = 8;
        this.c.anchor = GridBagConstraints.LINE_END;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(Box.createVerticalBox(), this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 2;
        this.c.gridy = 8;
        this.c.anchor = GridBagConstraints.LINE_END;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(Box.createVerticalBox(), this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.2;
        this.c.gridx = 3;
        this.c.gridy = 8;
        this.c.anchor = GridBagConstraints.LINE_END;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 0, 5);
        this.cb_NumToLetter.setActionCommand("NumToLetter"); //$NON-NLS-1$
        this.cb_NumToLetter.addActionListener(this.listener);
        add(this.cb_NumToLetter, this.c);

        // this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.1;
        this.c.gridx = 0;
        this.c.gridy = 9;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel("a ="), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 1;
        this.c.gridy = 9;
        this.c.gridwidth = 3;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_letter.setName("letter"); //$NON-NLS-1$
        this.tf_letter.addCaretListener(this.listener);
        add(this.tf_letter, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 10;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_letterToNum, this.c);

        // general panel settings
        setBackground(Color.black);
    }
}
