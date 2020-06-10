package pers.paopa.parser;

public class NumberFormatReplace {
    public static void main(String[] args) {
        String longString = "(638,486,831)";
        String doubleString = "(-15.10%)";
        String longStringAfterFilter = filterLongString(longString);
        System.out.println(Long.valueOf(longStringAfterFilter));
        String doubleStringAfterFilter = filterDoubleString(doubleString);
        System.out.println(Double.valueOf(doubleStringAfterFilter));
    }

    private static String filterDoubleString(String doubleString) {
        String doubleStringAfterFilter = doubleString
                .replaceAll(",|%|\\(|\\)", "");
        return doubleStringAfterFilter;
    }

    private static String filterLongString(String longString) {
        String longStringAfterFilter = longString
                .replaceAll(",|%|\\(|\\)", "");
        return longStringAfterFilter;
    }
}
