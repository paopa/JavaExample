package pers.pao.exception.simple;

public class OverrideMessageTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test() throws Exception {
        String x = "abcd";
        try {
            Integer.valueOf("asdf");
        } catch (Exception e) {
            throw new Exception("SQL:" + x, e);
        }
    }
}
