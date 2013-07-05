package model;

public class TreeNodeObject {

    private String  text;
    private int     methodID;
    private boolean selected, category;

    public TreeNodeObject(String text) {
        this.text = text;
        this.category = true;
    }

    public TreeNodeObject(String text, boolean isSelected, int methodID) {
        this.text = text;
        this.selected = isSelected;
        this.methodID = methodID;
        this.category = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean b) {
        selected = b;
    }

    public int getMethodID() {
        return methodID;
    }

    public boolean isCategory() {
        return category;
    }

    public String getText() {
        return text;
    }
}