package pers.paopa.regexp.simple;

public class ReplaceStringTest {

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        ReplaceStringTest test = new ReplaceStringTest();
        System.out.println(test.trimPrefix("vw_report_equipment_detail"));
    }

    private String trimPrefix(String primaryAlias) {
        String notPrefixAlias = primaryAlias.replaceFirst("vw_report_", "");
        return notPrefixAlias.substring(0, 1).toUpperCase() + notPrefixAlias.substring(1);
    }
}
