package controller;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class LangController {

    private static final String BUNDLE_NAME = "messages";
    static               String langCode    = "-en";

    public static String getString(String key) {
        try {
            return ResourceBundle.getBundle(BUNDLE_NAME + langCode).getString(key);
        } catch(MissingResourceException e) {
            return '!' + key + '!';
        }
    }

}
