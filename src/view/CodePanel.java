package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.net.URL;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ComboBoxUI;

import controller.Handler;
import model.MyComboBoxUI;

public class CodePanel extends JPanel {

    private final JComboBox<String>            codeBox;
    private final DefaultComboBoxModel<String> codeBoxModel;
    private final JLabel                       hide;
    private final Vector<String> recentCodes = new Vector<>();

    public CodePanel(Handler handler) {
        super();

        //set LayoutMng
        this.setLayout(new MigLayout("fill"));

        //setLayout
        this.setBackground(Color.BLACK);

        codeBoxModel = new DefaultComboBoxModel<>(recentCodes);

        codeBox = new JComboBox<>(codeBoxModel);
        codeBox.setBackground(Color.black);
        codeBox.setEditable(true);
        codeBox.setForeground(GUI3.guiColor);
        codeBox.setFont(GUI3.INGRESS_FONT);
        codeBox.setUI((ComboBoxUI) MyComboBoxUI.createUI());
        codeBox.setBorder(new BorderUIResource.EtchedBorderUIResource(GUI3.guiColor, Color.GRAY));
        codeBox.setName("codeBox");
        codeBox.getEditor().getEditorComponent().setName("codeBoxEdit");
        codeBox.getEditor().getEditorComponent().addKeyListener(handler);


        JButton decode = new JButton("Decode");
        decode.setBackground(Color.BLACK);
        decode.setForeground(GUI3.guiColor);
        decode.setFont(GUI3.INGRESS_FONT);

        hide = new JLabel(makeImageIcon("/images/fold_left.png"));
        hide.setForeground(GUI3.guiColor);
        hide.setFont(GUI3.INGRESS_FONT);
        hide.setName("hideSidebar");
        hide.setToolTipText("hide sidebar");
        hide.addMouseListener(handler);

        add(hide);
        add(codeBox, "growx, push");
        add(decode);
        decode.setActionCommand("decode");
        decode.addActionListener(handler);
    }

    private ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }

    public String getCode() {
        return codeBox.getEditor().getItem().toString();
    }

    public void addCodeToHistory() {
        if(!recentCodes.contains(getCode())) {
            recentCodes.add(getCode());
            codeBox.setModel(codeBoxModel);
        }
    }

    public void setCode(String newCode) {
        codeBox.getEditor().setItem(newCode);
    }

    public void changeHideIcon(boolean hidden) {
        hide.setIcon(hidden ? makeImageIcon("/images/fold_right.png") : makeImageIcon("/images/fold_left.png"));
        hide.setToolTipText(hidden ? "show sidebar" : "hide sidebar");
    }

}
