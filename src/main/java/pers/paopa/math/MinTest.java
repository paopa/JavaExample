package pers.paopa.math;

public class MinTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        int x = con(10,10);
        System.out.println(x);
    }

    private static int con(int x,int y) {
        return Math.min(x, y + 10);
    }
}
