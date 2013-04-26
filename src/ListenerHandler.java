import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ListenerHandler extends MouseMotionAdapter implements
        MouseListener, KeyListener, ActionListener, ChangeListener,
        CaretListener {

    public static void openWebsite(String url) {
        try {
            Runtime.getRuntime().exec(
                    "rundll32 url.dll,FileProtocolHandler " + url); //$NON-NLS-1$
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    GUI2        gui;
    Enlightened enl         = new Enlightened();
    Point       mouseclicked, windowlocation;
    boolean     numToLetter = false;

    public ListenerHandler(GUI2 mainGUI) {
        this.gui = mainGUI;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String code = this.gui.cb_code.getEditor().getItem().toString();
        if (command != null)
            if (command.equals("onTop")) //$NON-NLS-1$
                this.gui.setAlwaysOnTop(!this.gui.isAlwaysOnTop());
            else if (command.equals("liveDecode")) { //$NON-NLS-1$
                this.gui.islivedecode = !this.gui.islivedecode;
            } else if (command.equals("generate")) { //$NON-NLS-1$
                generateAll();
                addToComboBox();
            } else if (command.equals("conv_text")) { //$NON-NLS-1$
                convertDectoEverything(Ciphers.asctodec(code.trim()));
                this.gui.convert.tf_text.setText(code.trim());
            } else if (command.equals("conv_bin")) { //$NON-NLS-1$
                convertDectoEverything(Ciphers.bintodec(code.trim()));
                this.gui.convert.tf_bin.setText(code.trim());
            } else if (command.equals("conv_hex")) { //$NON-NLS-1$
                convertDectoEverything(Ciphers.hextodec(code.trim()));
                this.gui.convert.tf_hex.setText(code.trim());
            } else if (command.equals("conv_base64")) { //$NON-NLS-1$
                convertDectoEverything(Ciphers.base64todec(code.trim()));
                this.gui.convert.tf_base64.setText(code.trim());
            } else if (command.equals("conv_dec")) { //$NON-NLS-1$
                convertDectoEverything(code);
                this.gui.convert.tf_dec.setText(code.trim());
            } else if (command.equals("skip_up")) { //$NON-NLS-1$
                this.gui.cipher3.tf_skip.setText(Ciphers2
                        .getNextPossibleSkipNumber(this.gui.cipher3.tf_skip
                                .getText().trim(), code, false)
                        + ""); //$NON-NLS-1$
                if (this.gui.islivedecode) {
                    int number = 0;
                    try {
                        number = Integer.parseInt(this.gui.cipher3.tf_skip
                                .getText().trim());
                    } catch (Exception e1) {
                        number = 1;
                    }
                    this.gui.cipher3.tf_skipresult.setText(Ciphers2.skip(code,
                            number));
                }
            } else if (command.equals("skip_down")) { //$NON-NLS-1$
                this.gui.cipher3.tf_skip.setText(Ciphers2
                        .getNextPossibleSkipNumber(this.gui.cipher3.tf_skip
                                .getText().trim(), code, true)
                        + ""); //$NON-NLS-1$
                if (this.gui.islivedecode) {
                    int number = 0;
                    try {
                        number = Integer.parseInt(this.gui.cipher3.tf_skip
                                .getText().trim());
                    } catch (Exception e1) {
                        number = 1;
                    }
                    this.gui.cipher3.tf_skipresult.setText(Ciphers2.skip(code,
                            number));
                }
            } else if (command.equals("NumToLetter")) { //$NON-NLS-1$
                this.numToLetter = !this.numToLetter;
                int letter;
                if (this.gui.islivedecode) {
                    try {
                        letter = Integer.parseInt(this.gui.cipher2.tf_letter
                                .getText().trim());
                    } catch (Exception e1) {
                        letter = 1;
                    }
                    this.gui.cipher2.tf_letterToNum.setText(Ciphers
                            .numbertoletter(code.trim(), letter).trim());
                }
            }
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        if (e.getSource() != null) {
            String name = ((JTextField) e.getSource()).getName();
            String code = this.gui.cb_code.getEditor().getItem().toString();
            if (this.gui.islivedecode)
                if (name.equals("code"))// currently not used see key/action //$NON-NLS-1$
                                        // listener
                    generateAll();
                else if (name.equals("letter")) { //$NON-NLS-1$
                    int letter = 1;
                    try {
                        letter = Integer.parseInt(this.gui.cipher2.tf_letter
                                .getText().trim());
                    } catch (Exception e1) {
                        this.gui.cipher2.tf_letterToNum
                                .setText("ERROR 1: INVALID INPUT"); //$NON-NLS-1$
                    }
                    String result;
                    if (this.numToLetter)
                        result = Ciphers.numbertoletter(code, letter);
                    else result = Ciphers.lettertonumber(code, letter);
                    this.gui.cipher2.tf_letterToNum.setText(result);
                } else if (name.equals("skip")) { //$NON-NLS-1$
                    int number = 1;
                    try {
                        number = Integer.parseInt(this.gui.cipher3.tf_skip
                                .getText().trim());
                    } catch (Exception e1) {
                        this.gui.cipher3.tf_skipresult
                                .setText("ERROR 1: INVALID INPUT"); //$NON-NLS-1$
                    }
                    this.gui.cipher3.tf_skipresult.setText(Ciphers2.skip(code,
                            number));
                } else if (name.equals("vignere")) { //$NON-NLS-1$
                    this.gui.cipher2.tf_vinegere.setText(Ciphers.vinegere(code,
                            this.gui.cipher2.tf_vinegerepass.getText().trim()));
                } else if (name.equals("vignere_autokey")) { //$NON-NLS-1$
                    this.gui.cipher2.tf_vinegereautokey.setText(Ciphers
                            .vinegereAutokey(code,
                                    this.gui.cipher2.tf_vinegereautokeypass
                                            .getText().trim()));
                } else if (name.equals("binary")) { //$NON-NLS-1$
                    this.gui.cipher1.tf_patttobin.setText(Ciphers.patttobin(
                            code, this.gui.cipher1.tf_zeros.getText().trim(),
                            this.gui.cipher1.tf_ones.getText().trim()));
                } else if (name.equals("morse")) { //$NON-NLS-1$
                    this.gui.cipher1.tf_pattmorstoascii.setText(Ciphers
                            .pattmorstoascii(code, this.gui.cipher1.tf_short
                                    .getText().trim(), this.gui.cipher1.tf_long
                                    .getText().trim()));
                }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getComponent() != null) {
            String name = e.getComponent().getName();
            if (name.equals("code")) { //$NON-NLS-1$
                if (this.gui.islivedecode) generateAll();
                if (e.getKeyChar() == KeyEvent.VK_ENTER
                        || (e.isControlDown() && e.getKeyChar() + 64 == KeyEvent.VK_V)) {
                    addToComboBox();
                    generateAll();
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        String name = e.getComponent().getName();
        if (name != null) if (name.equals("close")) //$NON-NLS-1$
                System.exit(0);
            else if (name.equals("minimize")) //$NON-NLS-1$
                this.gui.setState(Frame.ICONIFIED);
            else if (name.equals("small")) //$NON-NLS-1$
                this.gui.setSize(new Dimension(500, 500));
            else if (name.equals("medium")) //$NON-NLS-1$
                this.gui.setSize(new Dimension(900, 500));
            else if (name.equals("large")) //$NON-NLS-1$
                this.gui.setSize(new Dimension(1300, 500));
            else if (name.equals("link1")) //$NON-NLS-1$
                openWebsite("http://www.xop.bplaced.de"); //$NON-NLS-1$
            else if (name.equals("link2")) //$NON-NLS-1$
                openWebsite("https://plus.google.com/communities/114606795989653285746/stream/a65f12d5-7722-46e1-87c7-fc05197652a5"); //$NON-NLS-1$
            else if (name.equals("link3")) //$NON-NLS-1$
                openWebsite("http://www.nianticproject.com/"); //$NON-NLS-1$
            else if (name.equals("link4")) //$NON-NLS-1$
                openWebsite("http://www.ingress.com/intel"); //$NON-NLS-1$
            else if (name.equals("mail")) //$NON-NLS-1$
                openWebsite("mailto:mail.xop@gmail.com?subject=Ingress%20Decoder"); //$NON-NLS-1$
            else if (name.equals("MOP")) //$NON-NLS-1$
                openWebsite("https://plus.google.com/100682658325412196401"); //$NON-NLS-1$
            else if (name.equals("Xeno")) //$NON-NLS-1$
                openWebsite("https://plus.google.com/101142446913397219075"); //$NON-NLS-1$
            else if (name.equals("Ee")) //$NON-NLS-1$
                this.enl.setVisible(true);
            else if (name.equals("flag_de")) //$NON-NLS-1$
                Main.redrawGUI("de"); //$NON-NLS-1$
            else if (name.equals("flag_en")) //$NON-NLS-1$
                Main.redrawGUI("en"); //$NON-NLS-1$
            else if (name.equals("flag_cn")) //$NON-NLS-1$
                Main.redrawGUI("cn"); //$NON-NLS-1$

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        this.gui.setLocation(this.windowlocation.x
                + (e.getLocationOnScreen().x - this.mouseclicked.x),
                this.windowlocation.y
                        + (e.getLocationOnScreen().y - this.mouseclicked.y));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        this.mouseclicked = e.getLocationOnScreen();
        this.windowlocation = this.gui.getLocation();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void stateChanged(ChangeEvent e) {
        String code = this.gui.cb_code.getEditor().getItem().toString();
        this.gui.cipher1.tf_caesarian.setText(Ciphers.caesarianShift(code,
                this.gui.cipher1.sl_caesarian.getValue()));

    }

    private void addToComboBox() {
        String code = this.gui.cb_code.getEditor().getItem().toString();
        if (!this.gui.codes.contains(code)) {
            this.gui.codes.add(code);
            this.gui.cb_code.setModel(this.gui.model);
        }
    }

    private void convertDectoEverything(String code) {
        String trimmedCode = code.trim();
        this.gui.convert.tf_text.setText(Ciphers.dectoasc(trimmedCode).trim());
        this.gui.convert.tf_bin.setText(Ciphers.dectobin(trimmedCode).trim());
        this.gui.convert.tf_hex.setText(Ciphers.dectohex(trimmedCode).trim());
        this.gui.convert.tf_base64.setText(Ciphers.dectobase64(trimmedCode)
                .trim());
        this.gui.convert.tf_dec.setText(trimmedCode);
    }

    private void generateAll() {
        // String code = this.gui.tf_code.getText().trim();
        String code = this.gui.cb_code.getEditor().getItem().toString();
        int letter = 1;
        int number = 1;
        // cipher 1
        this.gui.cipher1.tf_reversed.setText(Ciphers.reverse(code));
        this.gui.cipher1.tf_patttobin.setText(Ciphers.patttobin(code,
                this.gui.cipher1.tf_zeros.getText().trim(),
                this.gui.cipher1.tf_ones.getText().trim()));
        this.gui.cipher1.tf_pattmorstoascii.setText(Ciphers.pattmorstoascii(
                code, this.gui.cipher1.tf_short.getText().trim(),
                this.gui.cipher1.tf_long.getText().trim()));
        this.gui.cipher1.tf_caesarian.setText(Ciphers.caesarianShift(code,
                this.gui.cipher1.sl_caesarian.getValue()));
        // cipher 2
        this.gui.cipher2.tf_atbash.setText(Ciphers.atbash(code));
        this.gui.cipher2.tf_vinegere.setText(Ciphers.vinegere(code,
                this.gui.cipher2.tf_vinegerepass.getText().trim()));
        this.gui.cipher2.tf_vinegereautokey
                .setText(Ciphers.vinegereAutokey(code,
                        this.gui.cipher2.tf_vinegereautokeypass.getText()
                                .trim()));
        try {
            letter = Integer.parseInt(this.gui.cipher2.tf_letter.getText()
                    .trim());
        } catch (Exception e1) {
            letter = 1;
        }
        String result = ""; //$NON-NLS-1$
        if (this.numToLetter)
            result = Ciphers.numbertoletter(code.trim(), letter);
        else result = Ciphers.lettertonumber(code, letter);
        this.gui.cipher2.tf_letterToNum.setText(result);
        try {
            number = Integer
                    .parseInt(this.gui.cipher3.tf_skip.getText().trim());
        } catch (Exception e1) {
            number = 1;
        }
        this.gui.cipher3.tf_skipresult.setText(Ciphers2.skip(code, number));
    }
}
