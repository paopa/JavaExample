package per.pao.practice.guava.math.intmath;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
//        checkedAddTest();
//        divideTest();
//        logTest();
//        sqrtTest();
//        gcdTest();
//        modulusTest();
        factorialTest();
    }

    private static void factorialTest() {
        System.out.println(IntMath.factorial(2));
        System.out.println(IntMath.factorial(3));
        System.out.println(IntMath.factorial(5));
    }

    private static void modulusTest() {
        System.out.println(IntMath.mod(100, 50));
        System.out.println(IntMath.mod(100, 40));
        System.out.println(IntMath.mod(100, 30));
    }

    // a and b greatest common divisor
    private static void gcdTest() {
        System.out.println(IntMath.gcd(100, 50));
    }

    private static void sqrtTest() {
        System.out.println(IntMath.sqrt(IntMath.pow(10, 2), RoundingMode.HALF_EVEN));
    }

    private static void logTest() {
        System.out.println(IntMath.log2(2, RoundingMode.HALF_EVEN));
        System.out.println(IntMath.log10(10, RoundingMode.FLOOR));
    }

    private static void divideTest() {
        System.out.println(IntMath.divide(4, 2, RoundingMode.DOWN));
        System.out.println(IntMath.divide(100, 3, RoundingMode.DOWN));
        try {
            System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void checkedAddTest() {
        System.out.println(IntMath.checkedAdd(1, 1));

        try {
            System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
