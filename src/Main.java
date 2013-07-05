import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.GUI3;

public class Main {

    public static void main(String[] args) {
        try {
            for(LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch(Exception e) {
            // If Nimbus is not available, you can set the GUI to another look
            // and feel.
        }
        //        gui = new GUI2("en"
        //        gui.initGUI();
        new GUI3();
    }

}
