package pers.paopa.exception;

public class TryCatchTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try {
            Integer.valueOf("!@#");
        } catch (NumberFormatException e) {
            throw e;
        } finally {
            System.out.println(123);
        }
    }
}
