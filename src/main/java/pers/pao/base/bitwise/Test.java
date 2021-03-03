package pers.pao.base.bitwise;

public class Test {
    public static void main(String[] args) {
//        demo();
//        demoHasNegative();
        demoHasNegative2();
    }

    private static void demoHasNegative2() {
        int x = -16;
        printInfo(x);
        int y = x >>> 12;
        printInfo(y);
        System.out.println(y);

    }

    private static void demoHasNegative() {
        int x = -6;
        printInfo(x);
        int y = x >> 1;
        printInfo(y);
        System.out.println(y);
    }

    private static void demo() {
        int x = 16;
        printInfo(x);
        int y = x >> 2;
        printInfo(y);
        System.out.println(y);
    }

    private static void printInfo(int num) {
        System.out.println(Integer.toBinaryString(num));
    }
}
