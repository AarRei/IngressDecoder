package model;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ComboBoxEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicComboBoxEditor;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import view.GUI3;

public class MyComboBoxUI extends BasicComboBoxUI {

    public static ComponentUI createUI() {
        return new MyComboBoxUI();
    }

    private final Font mono = new Font(Font.MONOSPACED, Font.PLAIN, 14);

    ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }

    @Override
    protected JButton createArrowButton() {
        JButton button = new JButton(makeImageIcon("/images/dropdown.png")); //$NON-NLS-1$
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setRolloverIcon(makeImageIcon("/images/dropdown_hover.png")); //$NON-NLS-1$
        button.setPressedIcon(makeImageIcon("/images/dropdown_pressed.png")); //$NON-NLS-1$
        button.setContentAreaFilled(false);
        return button;
    }

    @Override
    protected ComboBoxEditor createEditor() {
        ComboBoxEditor editor1 = new BasicComboBoxEditor();
        editor1.getEditorComponent().setBackground(Color.black);
        editor1.getEditorComponent().setFont(this.mono);
        editor1.getEditorComponent().setForeground(GUI3.guiColor);
        return editor1;
    }

    @Override
    protected ComboPopup createPopup() {
        BasicComboPopup popup1 = new BasicComboPopup(this.comboBox);
        popup1.setBorder(new LineBorder(GUI3.guiColor, 1));
        popup1.getAccessibleContext().setAccessibleParent(this.comboBox);
        return popup1;
    }
}