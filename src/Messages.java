import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Messages {
    private static final String BUNDLE_NAME = "messages"; //$NON-NLS-1$

    static String               langCode    = "";        //$NON-NLS-1$

    public static String getString(String key) {
        langCode = "-" + GUI2.currentlang; //$NON-NLS-1$ 
        try {
            return ResourceBundle.getBundle(BUNDLE_NAME + langCode).getString(
                    key);
        } catch (MissingResourceException e) {
            return '!' + key + '!';
        }
    }

    private Messages() {
    }
}
