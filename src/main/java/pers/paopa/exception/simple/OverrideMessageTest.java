package pers.paopa.exception.simple;

import com.google.common.base.Throwables;

public class OverrideMessageTest {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
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
