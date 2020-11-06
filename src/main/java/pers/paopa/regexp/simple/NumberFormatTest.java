package pers.paopa.regexp.simple;

public class NumberFormatTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        String input = "$39 0423 615744";

        String temp = filterNumericString(input);
        Double.valueOf(temp);
        System.out.printf(temp);
    }

    private static String filterNumericString(String numericString) {
        return numericString.replaceAll("[,%()$ ]", "");
    }
}
