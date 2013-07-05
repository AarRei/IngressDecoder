package controller;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import ciphers.Ciphers;
import ciphers.Ciphers2;

public class CipherHandler {

    //    public static List<Integer>             activeCiphers = new ArrayList<>();
    public static Map<Integer, JPanel> activeCiphers = new HashMap<>();


    public static String[] getCipherInformation(int cipherID) {
        switch(cipherID) {
            case 1:
                return new String[]{"Atbash"};
            case 2:
                return new String[]{"Rotate"};
            case 10:
                return new String[]{"Letter to Number", "a="};
            case 11:
                return new String[]{"Number to Letter", "a="};
            case 12:
                return new String[]{"Vigenere Cipher", "Passphrase"};
            case 13:
                return new String[]{"Vigenere Autokey Cipher", "Passphrase"};
            case 30:
                return new String[]{"Pattern to binary", "0:", "1:"};
            case 31:
                return new String[]{"Morsepattern to ASCII", "short:", "long:"};
            case 40:
                return new String[]{"Caesarian Shift", "Shift:"};
            case 41:
                return new String[]{"Skip", "Skip:"};
            case 50:
                return new String[]{"Text/ASCII to Binary"};
            case 51:
                return new String[]{"Text/ASCII to Hex"};
            case 52:
                return new String[]{"Text/ASCII to Base64"};
            case 53:
                return new String[]{"Text/ASCII to Dec/Char"};
            case 54:
                return new String[]{"Binary to Text/ASCII"};
            case 55:
                return new String[]{"Binary to Hex"};
            case 56:
                return new String[]{"Binary to Base64"};
            case 57:
                return new String[]{"Binary to Dec/Char"};
            case 58:
                return new String[]{"Hex to Text/ASCII"};
            case 59:
                return new String[]{"Hex to Binary"};
            case 60:
                return new String[]{"Hex to Base64"};
            case 61:
                return new String[]{"Hex to Dec/Char"};
            case 62:
                return new String[]{"Base64 to Text/ASCII"};
            case 63:
                return new String[]{"Base64 to Binary"};
            case 64:
                return new String[]{"Base64 to Hex"};
            case 65:
                return new String[]{"Base64 to Dec/Char"};
            case 66:
                return new String[]{"Dec/Char to Text/ASCII"};
            case 67:
                return new String[]{"Dec/Char to Binary"};
            case 68:
                return new String[]{"Dec/Char to Hex"};
            case 69:
                return new String[]{"Dec/Char to Base64"};
            default:
                return null;
        }
    }

    public static String executeCipher(int cipherID, String code, String argument1, String argument2) {
        if(code == null || code.isEmpty()) return "";
        if(argument1 == null) argument1 = "";
        if(argument2 == null) argument2 = "";
        code = code.trim();
        switch(cipherID) {
            case 1:
                return Ciphers.atbash(code);
            case 2:
                return Ciphers.reverse(code);
            case 10:
                try {
                    return Ciphers.lettertonumber(code, Integer.parseInt(argument1));
                } catch(NumberFormatException e) {return "Parameter is no valid number!";} catch(Exception e) {
                    return "An Error occurred";
                }
            case 11:
                try {
                    return Ciphers.numbertoletter(code, Integer.parseInt(argument1));
                } catch(NumberFormatException e) {return "Parameter is no valid number!";} catch(Exception e) {
                    return "An Error occurred";
                }
            case 12:
                return Ciphers.vinegere(code, argument1);
            case 13:
                return Ciphers.vinegereAutokey(code, argument1);
            case 30:
                return Ciphers.patttobin(code, argument1, argument2);
            case 31:
                return Ciphers.pattmorstoascii(code, argument1, argument2);
            case 40:
                try {
                    return Ciphers.caesarianShift(code, Integer.parseInt(argument1));
                } catch(NumberFormatException e) {return "Parameter is no valid number!";} catch(Exception e) {
                    return "An Error occurred";
                }
            case 41:
                try {
                    return Ciphers2.skip(code, Integer.parseInt(argument1));
                } catch(NumberFormatException e) {return "Parameter is no valid number!";} catch(Exception e) {
                    return "An Error occurred";
                }
            case 50:
                return Ciphers.dectobin(Ciphers.asctodec(code).trim());
            case 51:
                return Ciphers.dectohex(Ciphers.asctodec(code).trim());
            case 52:
                return Ciphers.dectobase64(Ciphers.asctodec(code).trim());
            case 53:
                return Ciphers.asctodec(code);
            case 54:
                return Ciphers.dectoasc(Ciphers.bintodec(code).trim());
            case 55:
                return Ciphers.dectohex(Ciphers.bintodec(code).trim());
            case 56:
                return Ciphers.dectobase64(Ciphers.bintodec(code).trim());
            case 57:
                return Ciphers.bintodec(code);
            case 58:
                return Ciphers.dectoasc(Ciphers.hextodec(code).trim());
            case 59:
                return Ciphers.dectobin(Ciphers.hextodec(code).trim());
            case 60:
                return Ciphers.dectobase64(Ciphers.hextodec(code).trim());
            case 61:
                return Ciphers.hextodec(code);
            case 62:
                return Ciphers.dectoasc(Ciphers.base64todec(code).trim());
            case 63:
                return Ciphers.dectobin(Ciphers.base64todec(code).trim());
            case 64:
                return Ciphers.dectohex(Ciphers.base64todec(code).trim());
            case 65:
                return Ciphers.base64todec(code);
            case 66:
                return Ciphers.dectoasc(code);
            case 67:
                return Ciphers.dectobin(code);
            case 68:
                return Ciphers.dectohex(code);
            case 69:
                return Ciphers.dectobase64(code);
            default:
                return "";
        }
    }

}
