package pers.pao.jvm.stack.frame.local.variables;

import java.util.Date;

/**
 * 非 static method 會在 local variables index 0 放入 "this" variable
 * 也可以從這裡解釋為什麼 static method 不能調用 this
 *
 * slot 是可以被重複利用的，當前一個使用該 index 的 variable 被銷毀後
 * @see pers.pao.jvm.stack.frame.local.variables.Test#test4()
 */
public class Test {

    private int count = 0;

    public static void main(String[] args) {
        Test test = new Test();
        int num = 10;
        test.test1();
    }

    private static void testStatic() {
        String a = "asdf";
        Date date = new Date();
        int i = 10;
        System.out.println(i);
    }

    public Test() {
        this.count = 1;
    }

    private void test1() {
        Date date = new Date();
        String text = "asdf";
        String text2 = test2(date, text);
        System.out.println(text2);
        test3();
    }

    private String test2(Date date, String text) {
        date = null;
        text = "zxcv";
        double w = 10.1;// 使用 2 個 slots
        char c = '男';
        return date + text;
    }

    private void test3() {
        this.count++;
    }

    private void test4() {
        int a = 1;
        {
            int b = 1;
            a = b + a;
        }
        int c = 1;
    }
}
