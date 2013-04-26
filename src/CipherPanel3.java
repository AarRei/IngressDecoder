import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CipherPanel3 extends JPanel {

    private static final long serialVersionUID = -5697652893729686255L;

    GridBagConstraints        c                = new GridBagConstraints();
    Font                      textfont         = new Font("Courier New", 1, 15); //$NON-NLS-1$
    Color                     yellowColor      = new Color(0, 205, 106);
    Font                      mono             = new Font(Font.MONOSPACED,
                                                       Font.PLAIN, 12);
    ListenerHandler           listener;

    JTextField                tf_skip          = new JTextField("1"); //$NON-NLS-1$
    JTextField                tf_skipresult    = new JTextField();

    JButton                   btn_higher_skip  = new JButton("+"); //$NON-NLS-1$
    JButton                   btn_lower_skip   = new JButton("-"); //$NON-NLS-1$

    public CipherPanel3(ListenerHandler listenerHandler) {
        super(new GridBagLayout());
        this.listener = listenerHandler;

        // fields
        // fields that are not supposed to be editable are not anymore
        this.tf_skipresult.setEditable(false);

        // set the font to monospaced
        this.tf_skip.setFont(this.mono);
        this.tf_skipresult.setFont(this.mono);
        this.btn_higher_skip.setFont(this.mono);
        this.btn_higher_skip.setFont(this.mono);
        this.btn_lower_skip.setFont(this.mono);
        this.btn_lower_skip.setFont(this.mono);

        // set the design

        this.tf_skip.setBackground(Color.black);
        this.tf_skip.setForeground(this.yellowColor);
        this.tf_skipresult.setBackground(Color.black);
        this.tf_skipresult.setForeground(this.yellowColor);
        this.btn_higher_skip.setBackground(Color.black);
        this.btn_higher_skip.setForeground(this.yellowColor);
        this.btn_lower_skip.setBackground(Color.black);
        this.btn_lower_skip.setForeground(this.yellowColor);

        // add containers to panel
        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 0;
        this.c.gridy = 0;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 0, 5);
        add(GUI2.makeTextLabel(Messages.getString("CipherPanel3.Label_Skip")), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 0.05;
        this.c.gridx = 0;
        this.c.gridy = 1;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        add(GUI2.makeTextLabel(Messages.getString("CipherPanel3.Label_Skip_ValueDesc")), this.c); //$NON-NLS-1$

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 10.0;
        this.c.gridx = 1;
        this.c.gridy = 1;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.tf_skip.setName("skip"); //$NON-NLS-1$
        this.tf_skip.addCaretListener(this.listener);
        add(this.tf_skip, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 2;
        this.c.gridy = 1;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.btn_higher_skip.setActionCommand("skip_up"); //$NON-NLS-1$
        this.btn_higher_skip.addActionListener(listenerHandler);
        add(this.btn_higher_skip, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1.0;
        this.c.gridx = 3;
        this.c.gridy = 1;
        this.c.gridwidth = 1;
        this.c.insets = new Insets(0, 5, 2, 5);
        this.btn_lower_skip.setActionCommand("skip_down"); //$NON-NLS-1$
        this.btn_lower_skip.addActionListener(listenerHandler);
        add(this.btn_lower_skip, this.c);

        this.c.fill = GridBagConstraints.HORIZONTAL;
        this.c.weightx = 1;
        this.c.gridx = 0;
        this.c.gridy = 2;
        this.c.gridwidth = 4;
        this.c.insets = new Insets(0, 5, 5, 5);
        add(this.tf_skipresult, this.c);

        // general panel settings
        setBackground(Color.black);
    }

}
