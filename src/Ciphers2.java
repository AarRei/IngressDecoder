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
                return getNextPossibleSkipNumber(number + "", code, lowerValue); //$NON-NLS-1$
        }
        return number;
    }

    public static long[] primeFactors(long number) {

        // Maximale Faktoranzahl ermitteln
        int maxFactors = (int) Math.ceil(Math.log10(number) / Math.log10(2));

        if (maxFactors <= 0) maxFactors = 0;

        // Temporäres Array erzeugen
        long[] tmp = new long[maxFactors];

        // Zähler der tatsächlichen Faktoranzahl initialisieren
        int anzahlFaktoren = 0;

        for (long j = 2; j <= number; j++) {
            // Ist j Primfaktor?
            if (number % j == 0) {
                // Primfaktor sichern und Anzahl der Primfaktoren erhöhen
                tmp[anzahlFaktoren++] = j;
                // n ändern
                number = number / j;
                // j erneut auf Startwert 2 (1++) setzen
                j = 1;
            }
        }
        // Rückgabearray erzeugen, mit Länge der tatsächlichen Anzahl
        // von Primfaktoren
        long[] prf = new long[anzahlFaktoren];
        // Überführen der Werte des temporären Arrays in das
        // Rückgabearray
        for (int i = 0; i < anzahlFaktoren; i++) {
            prf[i] = tmp[i];
        }
        // Rückgabe
        return prf;
    }

    public static String skip(String code, int skip) {
        return skip(code, skip, primeFactors(code.length()));
    }

    public static String skip(String code, int skip, long[] primeFactors) {
        // check if code isnt null or empty
        if (code == null || code.equals("")) return ""; //$NON-NLS-1$ //$NON-NLS-2$
        // check if skip is smaller or equal to 1
        if (skip <= 1) return code;
        // check if skip is larger than length of code
        if (skip >= code.length())
            return Messages.getString("Ciphers2.Error_Skip1") //$NON-NLS-1$
                    .toUpperCase();
        // check if primeFactors contains skip
        for (long primeFactor : primeFactors) {
            if (skip % primeFactor == 0)
                return Messages.getString("Ciphers2.Error_Skip2") //$NON-NLS-1$
                        .toUpperCase();
        }
        String result = ""; //$NON-NLS-1$
        String input = ""; //$NON-NLS-1$
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
