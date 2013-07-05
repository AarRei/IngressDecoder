package model;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import controller.Handler;
import view.GUI3;

public class PopUpDemo extends JPopupMenu {

    public PopUpDemo(Handler handler) {
        this.setFont(GUI3.INGRESS_FONT);
        this.setForeground(GUI3.LIME_GREEN);

        JMenuItem decodeItem = new JMenuItem("Decode this!");
        decodeItem.setFont(GUI3.INGRESS_FONT);
        decodeItem.setForeground(GUI3.LIME_GREEN);
        decodeItem.setBackground(Color.black);
        decodeItem.setOpaque(true);
        decodeItem.setActionCommand("decodeIt");
        decodeItem.addActionListener(handler);
        add(decodeItem);
        JMenuItem copyItem = new JMenuItem("Copy this!");
        copyItem.setFont(GUI3.INGRESS_FONT);
        copyItem.setForeground(GUI3.LIME_GREEN);
        copyItem.setBackground(Color.black);
        copyItem.setOpaque(true);
        copyItem.setActionCommand("copyIt");
        copyItem.addActionListener(handler);
        add(copyItem);
    }

    @Override
    public void paintComponent(final Graphics g) {
        g.setColor(Color.black);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(GUI3.LIME_GREEN);
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}