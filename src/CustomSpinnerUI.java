import javax.swing.JComponent;
import javax.swing.plaf.ComponentUI;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class CustomSpinnerUI extends BasicSpinnerUI {

    public static ComponentUI createUI(JComponent c) {
        return new CustomSpinnerUI();
    }

}