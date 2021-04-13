package pers.pao;

public class Test {
    public static void main(String[] args) {
        System.out.println(division(100, 0));
    }

    private static int division(int i, int i1) {
        int result;
        try {
            result = i / i1;
            return result;
        } catch (ArithmeticException e) {
            return Integer.MIN_VALUE;
        } finally {
            result = Integer.MAX_VALUE;
        }
    }
}
