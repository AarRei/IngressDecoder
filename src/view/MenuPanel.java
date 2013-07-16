package view;

import net.miginfocom.swing.MigLayout;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import controller.Handler;
import model.TreeNodeObject;

public class MenuPanel extends JPanel {

    private final JTree        methodTree;
    private final Handler      handler;
    private       OptionsPanel optionPanel;
    private boolean optioncollapsed = true;
    private String  color           = "_green";
    private int random;

    public MenuPanel(final Handler handler, int random) {
        super();
        this.handler = handler;
        this.random = random;

        if(random == 0) color = "_green";
        else if(random == 1) color = "_blue";
        else color = "_orange";

        Border panelBorder = new LineBorder(GUI3.guiColor);

        //set LayoutMng
        this.setLayout(new MigLayout("fill"));
        this.setBorder(panelBorder);
        this.setBackground(Color.BLACK);

        DefaultMutableTreeNode top = new DefaultMutableTreeNode(new TreeNodeObject("Decoding Tools"));
        createNodes(top);
        methodTree = new JTree(top);
        methodTree.setBackground(Color.black);
        methodTree.setFont(GUI3.INGRESS_FONT);
        methodTree.setCellRenderer(new TreeCellRenderer());
        methodTree.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent evt) {
                TreePath path = methodTree.getPathForLocation(evt.getX(), evt.getY());
                if(path == null) return;
                DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                if(treeNode.getUserObject() instanceof TreeNodeObject) {
                    TreeNodeObject co = (TreeNodeObject) treeNode.getUserObject();
                    co.setSelected(!co.isSelected());
                    handler.toggleDecodingMethod(co.getMethodID());
                    methodTree.repaint();
                }
            }
        });

        JPanel toolbar = new JPanel();
        optionPanel = new OptionsPanel(handler, optioncollapsed, random);
        JScrollPane treeView = new JScrollPane(methodTree);
        treeView.setBorder(new EmptyBorder(0, 0, 0, 0));
        treeView.setFont(GUI3.INGRESS_FONT);

        JButton expandAll = new JButton(makeImageIcon("/images/expand_all" + color + ".png"));
        JButton collapseAll = new JButton(makeImageIcon("/images/collapse_all" + color + ".png"));
        JButton selectAll = new JButton(makeImageIcon("/images/check_all" + color + ".png"));
        JButton selectNone = new JButton(makeImageIcon("/images/check_none" + color + ".png"));
        JButton inverseSelection = new JButton(makeImageIcon("/images/check_invert" + color + ".png"));

        expandAll.setToolTipText("expand all");
        collapseAll.setToolTipText("collapse all");
        selectAll.setToolTipText("select all");
        selectNone.setToolTipText("deselect all");
        inverseSelection.setToolTipText("inverse selection");

        expandAll.setBackground(Color.black);
        collapseAll.setBackground(Color.black);
        selectAll.setBackground(Color.black);
        selectNone.setBackground(Color.black);
        inverseSelection.setBackground(Color.black);

        expandAll.setForeground(Color.green);
        collapseAll.setForeground(Color.green);
        selectAll.setForeground(Color.green);
        selectNone.setForeground(Color.green);
        inverseSelection.setForeground(Color.green);

        expandAll.setFont(GUI3.INGRESS_FONT);
        collapseAll.setFont(GUI3.INGRESS_FONT);
        selectAll.setFont(GUI3.INGRESS_FONT);
        selectNone.setFont(GUI3.INGRESS_FONT);
        inverseSelection.setFont(GUI3.INGRESS_FONT);

        expandAll.setActionCommand("TreeExpandAll");
        expandAll.addActionListener(handler);

        collapseAll.setActionCommand("TreeCollapseAll");
        collapseAll.addActionListener(handler);

        selectAll.setActionCommand("TreeSelectAll");
        selectAll.addActionListener(handler);

        selectNone.setActionCommand("TreeSelectNone");
        selectNone.addActionListener(handler);

        inverseSelection.setActionCommand("TreeInverseSelection");
        inverseSelection.addActionListener(handler);

        toolbar.setLayout(new MigLayout("gap 0, insets 0, fill"));
        toolbar.setBackground(Color.BLACK);
        toolbar.add(expandAll);
        toolbar.add(collapseAll);
        toolbar.add(selectAll);
        toolbar.add(selectNone);
        toolbar.add(inverseSelection);

        this.add(toolbar, "dock north");
        this.add(treeView, "growx, growy, push,wrap");
        this.add(optionPanel, "dock south");
    }


    ImageIcon makeImageIcon(String relative_path) {
        URL imgURL = getClass().getResource(relative_path);
        return new ImageIcon(imgURL);
    }

    public void expandMenu() {
        for(int i = 0; i < methodTree.getRowCount(); i++) methodTree.expandRow(i);
    }

    public void collapseMenu() {
        for(int i = 1; i < methodTree.getRowCount(); i++) methodTree.collapseRow(i);

    }

    public void inverseSelection() {
        expandMenu();
        for(int i = 0; i < methodTree.getRowCount(); i++) {
            TreePath path = methodTree.getPathForRow(i);
            if(path == null) return;
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            if(treeNode.getUserObject() instanceof TreeNodeObject) {
                TreeNodeObject co = (TreeNodeObject) treeNode.getUserObject();
                if(co.isNoCategory()) {
                    co.setSelected(!co.isSelected());
                    handler.toggleDecodingMethod(co.getMethodID());
                }
            }
        }
        methodTree.repaint();
    }

    public void selectNone() {
        expandMenu();
        for(int i = 0; i < methodTree.getRowCount(); i++) {
            TreePath path = methodTree.getPathForRow(i);
            if(path == null) return;
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            if(treeNode.getUserObject() instanceof TreeNodeObject) {
                TreeNodeObject co = (TreeNodeObject) treeNode.getUserObject();
                if(co.isSelected() && co.isNoCategory()) {
                    co.setSelected(false);
                    handler.toggleDecodingMethod(co.getMethodID());
                }
            }
        }
        methodTree.repaint();
    }

    public void selectAll() {
        expandMenu();
        for(int i = 0; i < methodTree.getRowCount(); i++) {
            TreePath path = methodTree.getPathForRow(i);
            if(path == null) return;
            DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) path.getLastPathComponent();
            if(treeNode.getUserObject() instanceof TreeNodeObject) {
                TreeNodeObject co = (TreeNodeObject) treeNode.getUserObject();
                if(!co.isSelected() && co.isNoCategory()) {
                    co.setSelected(true);
                    handler.toggleDecodingMethod(co.getMethodID());
                }
            }
        }
        methodTree.repaint();
    }

    private void createNodes(DefaultMutableTreeNode top) {
        DefaultMutableTreeNode category;
        DefaultMutableTreeNode subcategory;

        category = new DefaultMutableTreeNode(new TreeNodeObject("Basic Ciphers"));
        top.add(category);

        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Atbash", false, 1)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Rotate", false, 2)));


        category = new DefaultMutableTreeNode(new TreeNodeObject("Advanced Ciphers"));
        top.add(category);

        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Letter to Number", false, 10)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Number to Letter", false, 11)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Vigenere", false, 12)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Vigenere Autokey", false, 13)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Pattern to Binary", false, 30)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Morsepattern to ASCII", false, 31)));

        category = new DefaultMutableTreeNode(new TreeNodeObject("Special Ciphers"));
        top.add(category);

        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Caesarian Shift", false, 40)));
        category.add(new DefaultMutableTreeNode(new TreeNodeObject("Skip", false, 41)));

        category = new DefaultMutableTreeNode(new TreeNodeObject("Converter"));
        top.add(category);

        subcategory = new DefaultMutableTreeNode(new TreeNodeObject("Text/ASCII"));
        category.add(subcategory);

        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Binary", false, 50)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Hex", false, 51)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Base64", false, 52)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Dec/Char", false, 53)));

        subcategory = new DefaultMutableTreeNode(new TreeNodeObject("Binary"));
        category.add(subcategory);

        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Text/ASCII", false, 54)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Hex", false, 55)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Base64", false, 56)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Dec/Char", false, 57)));

        subcategory = new DefaultMutableTreeNode(new TreeNodeObject("Hex"));
        category.add(subcategory);

        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Text/ASCII", false, 58)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Binary", false, 59)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Base64", false, 60)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Dec/Char", false, 61)));

        subcategory = new DefaultMutableTreeNode(new TreeNodeObject("Base64"));
        category.add(subcategory);

        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Text/ASCII", false, 62)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Binary", false, 63)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Hex", false, 64)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Dec/Char", false, 65)));

        subcategory = new DefaultMutableTreeNode(new TreeNodeObject("Dec/Char"));
        category.add(subcategory);

        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Text/ASCII", false, 66)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Binary", false, 67)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Hex", false, 68)));
        subcategory.add(new DefaultMutableTreeNode(new TreeNodeObject("to Base64", false, 69)));
    }

    public void toggleOptions() {
        optioncollapsed = !optioncollapsed;
        this.remove(optionPanel);
        this.add(optionPanel = new OptionsPanel(handler, optioncollapsed, random), "dock south");
        this.revalidate();
    }
}
