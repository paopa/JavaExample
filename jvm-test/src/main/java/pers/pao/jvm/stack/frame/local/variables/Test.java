package pers.pao.jvm.stack.frame.local.variables;

import java.util.Date;

public class Test {

    private int count = 0;

    public static void main(String[] args) {
        Test test = new Test();
        int num = 10;
        test.test1();
    }

    private void test1() {
        Date date = new Date();
        String text = "asdf";
        String text2 = test2(date, text);
        System.out.println(text2);
    }

    private static void testStatic(){
        String a = "asdf";
        Date date = new Date();
        int i = 10;
        System.out.println(i);
    }

    private String test2(Date date, String text) {
        date = null;
        text = "zxcv";
        double w = 10.1;
        char c = '男';
        return date + text;
    }
}
