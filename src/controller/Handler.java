package controller;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import ciphers.Ciphers2;
import model.PopUpDemo;
import view.AboutUsPanel;
import view.CipherPanel;
import view.Enlightened;
import view.GUI3;

public class Handler implements MouseListener, ActionListener, KeyListener, CaretListener, ChangeListener {

    private final GUI3       parent;
    private       boolean    liveDecode;
    private       JTextField skipInputField;
    private       JDialog    aboutDialog;
    private       String     lastRightClickedCode;


    public Handler(GUI3 mainGUI) {
        this.parent = mainGUI;
    }

    public void setSkipInputField(JTextField skipInputField) {
        this.skipInputField = skipInputField;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().getName().equals("optionToggle")) parent.getMenuPanel().toggleOptions();
        else if(e.getComponent().getName().equals("hideSidebar")) parent.toggleSidebar();
        else if(e.getComponent().getName().equals("TitleText")) new Enlightened().setVisible(true);
        else if(e.getComponent().getName().equals("globeMenu")) (aboutDialog = new AboutUsPanel(this)).setVisible(true);
        else if(e.getComponent().getName().equals("weblink1")) openUrl("http://www.blog.xop.bplaced.net");
        else if(e.getComponent().getName().equals("weblink2"))
            openUrl("https://plus.google.com/communities/114606795989653285746");
        else if(e.getComponent().getName().equals("weblink3")) openUrl("http://www.nianticproject.com/");
        else if(e.getComponent().getName().equals("weblink4")) openUrl("http://www.ingress.com/intel");
        else if(e.getComponent().getName().equals("contactMail"))
            openUrl("mailto:mail.xop@gmail.com?subject=Ingress%20Decoder");
        else if(e.getComponent().getName().equals("GPlusXOP")) openUrl("https://plus.google.com/101804890644445925541");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getComponent().getName().equals("CipherResult") && e.isPopupTrigger()) doPop(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getComponent().getName().equals("CipherResult") && e.isPopupTrigger()) doPop(e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getComponent().getName().equals("globeMenu")) parent.getTitlePanel().hoverGlobe();

    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().getName().equals("globeMenu")) parent.getTitlePanel().hoverGlobe();
    }

    private void doPop(MouseEvent e) {
        PopUpDemo menu = new PopUpDemo(this);
        lastRightClickedCode = ((JTextField) e.getComponent()).getText().trim();
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

    public void toggleDecodingMethod(int methodID) {
        if(methodID > 0) {
            if(!CipherHandler.activeCiphers.containsKey(methodID)) {
                CipherHandler.activeCiphers.put(methodID, new CipherPanel(methodID).createPanel(this));
            }
            else CipherHandler.activeCiphers.remove(methodID);
            parent.updateDecoderPanel();
            if(isLiveDecode()) parent.executeCiphers();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch(command) {
            case "decode":
                parent.executeCiphers();
                break;
            case "TreeExpandAll":
                parent.getMenuPanel().expandMenu();
                break;
            case "TreeCollapseAll":
                parent.getMenuPanel().collapseMenu();
                break;
            case "TreeSelectAll":
                parent.getMenuPanel().selectAll();
                break;
            case "TreeSelectNone":
                parent.getMenuPanel().selectNone();
                break;
            case "TreeInverseSelection":
                parent.getMenuPanel().inverseSelection();
                break;
            case "alwaysOnTop":
                parent.toggleAlwaysOnTop();
                break;
            case "liveDecode":
                liveDecode = !isLiveDecode();
                break;
            case "closeDialog":
                if(aboutDialog != null) aboutDialog.dispose();
                break;
            case "copyIt":
                if(lastRightClickedCode != null && !lastRightClickedCode.isEmpty()) {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();
                    Clipboard clipboard = toolkit.getSystemClipboard();
                    StringSelection strSel = new StringSelection(lastRightClickedCode);
                    clipboard.setContents(strSel, null);
                }
                break;
            case "decodeIt":
                if(lastRightClickedCode != null && !lastRightClickedCode.isEmpty()) {
                    parent.getCodePanel().setCode(lastRightClickedCode);
                    parent.addCodeToHistory();
                    parent.executeCiphers();
                }
                break;
            case "skipCipherDown":
                if(skipInputField != null)
                    skipInputField.setText(String.valueOf(Ciphers2.getNextPossibleSkipNumber(skipInputField.getText()
                                                                                                           .trim(),
                                                                                             parent.getCodePanel()
                                                                                                   .getCode(),
                                                                                             true)));
                if(liveDecode) parent.executeCipher(41);
                break;
            case "skipCipherUp":
                if(skipInputField != null)
                    skipInputField.setText(String.valueOf(Ciphers2.getNextPossibleSkipNumber(skipInputField.getText()
                                                                                                           .trim(),
                                                                                             parent.getCodePanel()
                                                                                                   .getCode(),
                                                                                             false)));
                if(liveDecode) parent.executeCipher(41);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //nothin happens
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getComponent() != null) {
            if(e.getComponent().getName().equals("codeBoxEdit")) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER || (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V)) {
                    parent.addCodeToHistory();
                    parent.executeCiphers();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getComponent() != null)
            if(e.getComponent().getName().equals("codeBoxEdit")) if(isLiveDecode()) parent.executeCiphers();
    }

    @Override
    public void caretUpdate(CaretEvent e) {
        if(isLiveDecode()) {
            try {
                int methodID = Integer.parseInt(((JTextField) e.getSource()).getName());
                parent.executeCipher(methodID);
            } catch(Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean isLiveDecode() {
        return liveDecode;
    }

    public boolean isAlwaysOnTop() {
        return parent.isAlwaysOnTop();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if(isLiveDecode()) parent.executeCipher(40);
    }


    void openUrl(String url) {
        try {
            if(java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

                if(desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    java.net.URI uri = new java.net.URI(url);
                    desktop.browse(uri);
                }
            }
        } catch(Exception e) {
            //Something went wrong
        }
    }


}
