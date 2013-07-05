package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.TreeNodeObject;

public class TreeCellRenderer extends DefaultTreeCellRenderer {

    private DefaultMutableTreeNode treeNode;
    private TreeNodeObject         chObj;
    private JCheckBox chBox = new JCheckBox();

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        treeNode = (DefaultMutableTreeNode) value;

        if(treeNode.getUserObject() instanceof TreeNodeObject) {
            chObj = (TreeNodeObject) treeNode.getUserObject();
            if(!chObj.isCategory()) {
                chBox.setText(chObj.getText());
                chBox.setSelected(chObj.isSelected());
                chBox.setBackground(Color.black);
                chBox.setForeground(GUI3.LIME_GREEN);
                chBox.setFont(GUI3.INGRESS_FONT);
                return chBox;
            }
            else {
                JLabel title = new JLabel(chObj.getText());
                title.setForeground(GUI3.LIME_GREEN);
                title.setFont(GUI3.INGRESS_FONT);
                return title;
            }

        }
        this.setIcon(null);
        return this;
    }
}