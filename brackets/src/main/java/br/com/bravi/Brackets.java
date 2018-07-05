package br.com.bravi;

public class Brackets {

    private static final String[][] BRACKETS = {{"{", "}"}, {"[", "]"}, {"(", ")"}};

    public static boolean isValid(String string) {
        boolean valid = false;
        for (String[] b : BRACKETS) {
            for (int i = 0; i < b.length; i++) {
                if (string.indexOf(b[0]) < string.indexOf(b[1])) {
                    valid = true;
                }else{
                    valid = false;
                }
            }
        }
        return valid;
    }
}
