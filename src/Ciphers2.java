public class Ciphers2 {

    public static int getNextPossibleSkipNumber(String currentNumber,
            String code, boolean lowerValue) {
        if (code.length() == 0) return 1;
        int number = 1;
        try {
            number = Integer.parseInt(currentNumber) + 1;
        } catch (NumberFormatException e) {
            number = 1;
        }
        if (lowerValue) number = number - 2;
        int codeLength = code.length();
        if (lowerValue && number <= 1) return 1;
        while (number > 0 && codeLength % number == 0)
            if (!lowerValue)
                number++;
            else number--;
        // primeFactor check otherwise start over
        long primeFactors[] = primeFactors(codeLength);
        for (long primeFactor : primeFactors) {
            if (number % primeFactor == 0)
                return getNextPossibleSkipNumber(number + "", code, lowerValue);
        }
        return number;
    }

    public static long[] primeFactors(long number) {

        // Maximale Faktoranzahl ermitteln
        int maxFactors = (int) Math.ceil(Math.log10(number) / Math.log10(2));

        // Tempor�res Array erzeugen
        long[] tmp = new long[maxFactors];

        // Z�hler der tats�chlichen Faktoranzahl initialisieren
        int anzahlFaktoren = 0;

        for (long j = 2; j <= number; j++) {
            // Ist j Primfaktor?
            if (number % j == 0) {
                // Primfaktor sichern und Anzahl der Primfaktoren erh�hen
                tmp[anzahlFaktoren++] = j;
                // n �ndern
                number = number / j;
                // j erneut auf Startwert 2 (1++) setzen
                j = 1;
            }
        }
        // R�ckgabearray erzeugen, mit L�nge der tats�chlichen Anzahl
        // von Primfaktoren
        long[] prf = new long[anzahlFaktoren];
        // �berf�hren der Werte des tempor�ren Arrays in das
        // R�ckgabearray
        for (int i = 0; i < anzahlFaktoren; i++) {
            prf[i] = tmp[i];
        }
        // R�ckgabe
        return prf;
    }

    public static String skip(String code, int skip) {
        return skip(code, skip, primeFactors(code.length()));
    }

    public static String skip(String code, int skip, long[] primeFactors) {
        // check if code isnt null or empty
        if (code == null || code == "") return "";
        // check if skip is smaller or equal to 1
        if (skip <= 1) return code;
        // check if skip is larger than length of code
        if (skip >= code.length())
            return "error 1: Skip must be smaller than the length of the text."
                    .toUpperCase();
        // check if primeFactors contains skip
        for (long primeFactor : primeFactors) {
            if (skip % primeFactor == 0)
                return "error 1: Skip has a prime factor that cleanly divides into the text length, so it can not be used."
                        .toUpperCase();
        }
        String result = "";
        String input = "";
        // concat code to itself skip times
        for (int i = 0; i < skip; i++)
            input += code;
        // skip use first letter, then every 1+skip letter
        for (int i = 0; i < input.length(); i += skip) {
            result += input.charAt(i);
        }
        return result;
    }
}
