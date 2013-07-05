package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import controller.CipherHandler;
import controller.Handler;

public class CipherPanel extends JPanel {

    private JLabel cipherTitle, regExImage, argument1Title, argument2Title;
    private ImageIcon  regExCheck;
    private JTextField cipherResult, argument1Input, argument2Input;
    private JSlider sl_caesarian = new JSlider(SwingConstants.HORIZONTAL, 0, 25, 0);
    private int    cipherID;
    private String extraValue1, extraValue2;
    private JButton btn_skip_up, btn_skip_down;
    private String[] cipherInformation;
    private boolean  specialCipher;
    private final String regEx1 = "[2-9][p-z][a-h][2-9][a-z]*[p-z][2-9][p-z][2-9][p-z]",
            regEx2 = "[2-9][p-z][p-z][a-h][2-9][a-z]*[p-z][2-9][2-9][2-9][p-z]";

    public CipherPanel(int cipherID) {
        this.cipherID = cipherID;
        this.cipherResult = new JTextField();
        this.regExCheck = makeImageIcon("/images/regex_maybe.png");
        this.regExImage = new JLabel(regExCheck);
        this.cipherInformation = CipherHandler.getCipherInformation(cipherID);
        if(cipherID > 39 && cipherID < 50) specialCipher = true;
    }

    public JPanel createPanel(Handler handler) {
        Border fieldBorder = new LineBorder(GUI3.LIME_GREEN, 1);
        Border border = new LineBorder(GUI3.LIME_GREEN, 2);

        this.cipherTitle = new JLabel(cipherInformation[0]);
        this.cipherTitle.setForeground(GUI3.LIME_GREEN);
        this.cipherTitle.setFont(GUI3.INGRESS_FONT);

        //cipher with 1 extra argument
        if(!specialCipher && cipherInformation.length == 2) {
            argument1Title = new JLabel(cipherInformation[1]);
            argument1Title.setForeground(GUI3.LIME_GREEN);
            argument1Title.setFont(GUI3.INGRESS_FONT);
            argument1Input = new JTextField();
            argument1Input.setForeground(GUI3.LIME_GREEN);
            argument1Input.setFont(GUI3.INGRESS_FONT);
            argument1Input.setBackground(Color.BLACK);
            argument1Input.setBorder(fieldBorder);
            argument1Input.setName(cipherID + "");
            argument1Input.addCaretListener(handler);
        }
        //cipher with 2 extra arguments
        if(!specialCipher && cipherInformation.length == 3) {
            argument1Title = new JLabel(cipherInformation[1]);
            argument1Title.setForeground(GUI3.LIME_GREEN);
            argument1Title.setFont(GUI3.INGRESS_FONT);
            argument1Input = new JTextField();
            argument1Input.setForeground(GUI3.LIME_GREEN);
            argument1Input.setFont(GUI3.INGRESS_FONT);
            argument1Input.setBackground(Color.BLACK);
            argument1Input.setBorder(fieldBorder);
            argument1Input.setName(cipherID + "");
            argument1Input.addCaretListener(handler);

            argument2Title = new JLabel(cipherInformation[2]);
            argument2Title.setForeground(GUI3.LIME_GREEN);
            argument2Title.setFont(GUI3.INGRESS_FONT);
            argument2Input = new JTextField();
            argument2Input.setForeground(GUI3.LIME_GREEN);
            argument2Input.setFont(GUI3.INGRESS_FONT);
            argument2Input.setBackground(Color.BLACK);
            argument2Input.setBorder(fieldBorder);
            argument2Input.setName(cipherID + "");
            argument2Input.addCaretListener(handler);
        }

        if(specialCipher) {
            switch(cipherID) {
                //slider
                case 40:
                    argument1Title = new JLabel(cipherInformation[1]);
                    argument1Title.setForeground(GUI3.LIME_GREEN);
                    argument1Title.setFont(GUI3.INGRESS_FONT);

                    // slider settings
                    sl_caesarian.addChangeListener(handler);
                    sl_caesarian.setMajorTickSpacing(5);
                    sl_caesarian.setMinorTickSpacing(1);
                    sl_caesarian.setPaintTicks(true);
                    sl_caesarian.setPaintLabels(true);
                    sl_caesarian.setBackground(Color.black);
                    sl_caesarian.setForeground(GUI3.LIME_GREEN);
                    sl_caesarian.setFont(GUI3.INGRESS_FONT);
                    break;
                //skip
                case 41:
                    argument1Title = new JLabel(cipherInformation[1]);
                    argument1Title.setForeground(GUI3.LIME_GREEN);
                    argument1Title.setFont(GUI3.INGRESS_FONT);

                    argument1Input = new JTextField();
                    argument1Input.setForeground(GUI3.LIME_GREEN);
                    argument1Input.setFont(GUI3.INGRESS_FONT);
                    argument1Input.setBackground(Color.BLACK);
                    argument1Input.setFont(Font.getFont(Font.MONOSPACED));
                    argument1Input.setBorder(fieldBorder);
                    argument1Input.setName(cipherID + "");
                    argument1Input.addCaretListener(handler);
                    //both buttons
                    btn_skip_up = new JButton("+");
                    btn_skip_up.setActionCommand("skipCipherUp");
                    btn_skip_up.addActionListener(handler);
                    btn_skip_up.setBackground(Color.black);
                    btn_skip_up.setForeground(GUI3.LIME_GREEN);
                    btn_skip_up.setFont(GUI3.INGRESS_FONT);
                    btn_skip_down = new JButton("-");
                    btn_skip_down.setActionCommand("skipCipherDown");
                    btn_skip_down.addActionListener(handler);
                    btn_skip_down.setBackground(Color.black);
                    btn_skip_down.setForeground(GUI3.LIME_GREEN);
                    btn_skip_down.setFont(GUI3.INGRESS_FONT);
                    btn_skip_down.setText("-");
                    handler.setSkipInputField(argument1Input);
                    break;
            }
        }

        cipherResult.setForeground(GUI3.LIME_GREEN);
        cipherResult.setFont(GUI3.INGRESS_FONT);
        cipherResult.setBackground(Color.BLACK);
        cipherResult.setBorder(fieldBorder);
        cipherResult.setName("CipherResult");
        cipherResult.addMouseListener(handler);

        this.setLayout(new MigLayout("fill"));
        this.setBackground(Color.BLACK);
        this.setForeground(GUI3.LIME_GREEN);

        Border panelBorder = new TitledBorder(border, cipherInformation[0], TitledBorder.LEADING, TitledBorder.TOP,
                                              GUI3.INGRESS_FONT, GUI3.LIME_GREEN);
        this.setBorder(panelBorder);

        cipherResult.setEditable(false);

        //        add(cipherTitle, "wrap");
        if(!specialCipher && cipherInformation.length == 2) {
            add(argument1Title);
            add(argument1Input, "wrap, growx, push");
        }
        if(!specialCipher && cipherInformation.length == 3) {
            add(argument1Title);
            add(argument1Input, "growx, pushx, w min:50%");
            add(argument2Title);
            add(argument2Input, "growx,pushx, w min:50%, wrap");
        }
        if(specialCipher) {
            switch(cipherID) {
                //slider
                case 40:
                    add(argument1Title);
                    add(sl_caesarian, "growx, pushx, wrap");
                    break;
                //skip
                case 41:
                    add(argument1Title);
                    add(argument1Input, "growx,push");
                    add(btn_skip_up);
                    add(btn_skip_down, "wrap");
                    break;
            }
        }
        add(cipherResult, "span 4, growx,push");
        add(regExImage);
        return this;
    }


    public void executeCipher(String code) {
        extraValue1 = "";
        extraValue2 = "";
        if(!specialCipher && cipherInformation.length == 2) {
            extraValue1 = argument1Input.getText().trim();
        }
        if(!specialCipher && cipherInformation.length == 3) {
            extraValue1 = argument1Input.getText().trim();
            extraValue2 = argument2Input.getText().trim();
        }
        if(specialCipher) switch(cipherID) {
            //slider
            case 40:
                extraValue1 = String.valueOf(sl_caesarian.getValue());
                break;
            //skip
            case 41:
                extraValue1 = argument1Input.getText().trim();
                break;
        }
        cipherResult.setText(CipherHandler.executeCipher(cipherID, code, extraValue1, extraValue2).trim());
        switch(checkRegEx(cipherResult.getText())) {
            case 1:
                regExImage.setIcon(makeImageIcon("/images/regex_yes.png"));
                break;
            case 2:
                regExImage.setIcon(makeImageIcon("/images/regex_no.png"));
                break;
            default:
                regExImage.setIcon(makeImageIcon("/images/regex_maybe.png"));
                break;
        }
        revalidate();
    }

    /**
     * @param result
     *         the encoded string
     *
     * @return 0 - maybe </br> 1 - yes </br> 2 - no
     */
    private int checkRegEx(String result) {
        if(result == null || result.isEmpty()) return 0;
        result = result.toLowerCase();
        if(result.matches(regEx1) || result.matches(regEx2)) return 1;
        return 2;

    }

    private ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
