package pers.pao.base.extend.method.overload;

/**
 * byte 8 有號
 * short 16 有號
 * int 32 有號
 * char 16 但為單一只有正數
 */
public class PrimitiveTest {
    public static void main(String[] args) {
        byte i = 10;
        test(i);
    }

    public static void test(byte b) {
        System.out.println("b");
    }

    public static void test(short s) {
        System.out.println("s");
    }

    public static void test(char c) {
        System.out.println("c");
    }

    public static void test(int i) {
        System.out.println("i");
    }
}
