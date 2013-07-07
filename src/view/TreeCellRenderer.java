package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import model.TreeNodeObject;

class TreeCellRenderer extends DefaultTreeCellRenderer {

    private final JCheckBox chBox = new JCheckBox();

    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                  boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) value;

        if(treeNode.getUserObject() instanceof TreeNodeObject) {
            TreeNodeObject chObj = (TreeNodeObject) treeNode.getUserObject();
            if(chObj.isNoCategory()) {
                chBox.setText(chObj.getText());
                chBox.setSelected(chObj.isSelected());
                chBox.setBackground(Color.black);
                chBox.setForeground(GUI3.guiColor);
                chBox.setFont(GUI3.INGRESS_FONT);
                return chBox;
            }
            else {
                JLabel title = new JLabel(chObj.getText());
                title.setForeground(GUI3.guiColor);
                title.setFont(GUI3.INGRESS_FONT);
                return title;
            }

        }
        this.setIcon(null);
        return this;
    }
}