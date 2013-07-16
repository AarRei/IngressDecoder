package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.Handler;

class OptionsPanel extends JPanel {

    private String color = "_green";

    public OptionsPanel(Handler handler, boolean optioncollapsed, int random) {
        super();

        if(random == 0) color = "_green";
        else if(random == 1) color = "_blue";
        else color = "_orange";

        this.setLayout(new MigLayout("fill"));
        this.setBackground(Color.black);

        JPanel titlePanel = new JPanel(new MigLayout("fill"));
        JPanel optionPanel = new JPanel(new MigLayout("fill"));

        JLabel optionText = new JLabel("Options");
        JLabel optionToggleImage = new JLabel(optioncollapsed ? makeImageIcon("/images/fold_up" + color + ".png") :
                                                      makeImageIcon("/images/fold_down" + color + ".png"));
        optionToggleImage.setToolTipText(optioncollapsed ? "show options" : "hide options");
        JCheckBox liveDecode = new JCheckBox("Live Decode");
        JCheckBox alwaysOnTop = new JCheckBox("Always on top");

        optionText.setBackground(Color.black);
        optionToggleImage.setBackground(Color.black);
        liveDecode.setBackground(Color.black);
        alwaysOnTop.setBackground(Color.black);

        optionText.setForeground(GUI3.guiColor);
        optionToggleImage.setForeground(GUI3.guiColor);
        liveDecode.setForeground(GUI3.guiColor);
        alwaysOnTop.setForeground(GUI3.guiColor);

        optionText.setFont(GUI3.INGRESS_FONT);
        optionToggleImage.setFont(GUI3.INGRESS_FONT);
        liveDecode.setFont(GUI3.INGRESS_FONT);
        alwaysOnTop.setFont(GUI3.INGRESS_FONT);

        titlePanel.setBackground(Color.black);
        optionPanel.setBackground(Color.black);

        optionToggleImage.setName("optionToggle");
        optionToggleImage.addMouseListener(handler);

        setName("optionToggle");
        addMouseListener(handler);

        titlePanel.setBorder(new LineBorder(GUI3.guiColor, 1));
        optionPanel.setBorder(new LineBorder(GUI3.guiColor, 1));

        titlePanel.add(optionText, "growx, push");
        titlePanel.add(optionToggleImage);

        if(handler.isLiveDecode()) liveDecode.setSelected(true);
        if(handler.isAlwaysOnTop()) alwaysOnTop.setSelected(true);

        liveDecode.setActionCommand("liveDecode");
        liveDecode.addActionListener(handler);
        alwaysOnTop.setActionCommand("alwaysOnTop");
        alwaysOnTop.addActionListener(handler);

        optionPanel.add(liveDecode, "wrap");
        optionPanel.add(alwaysOnTop);

        add(titlePanel, "growx, wrap");
        if(!optioncollapsed) add(optionPanel, "growx, growy, push");
    }

    private ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }
}
