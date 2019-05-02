package org.Forsikringsregister;

public class NumberParser {
    public static int parseNumber(String str, String errorMessage) throws NumberFormatException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(errorMessage);
        }

        return number;
    }
}
