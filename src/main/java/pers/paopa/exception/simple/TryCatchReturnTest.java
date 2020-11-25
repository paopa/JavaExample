package pers.paopa.exception.simple;

public class TryCatchReturnTest {
    public static void main(String[] args) {
        try {
            return;
        } catch (Exception e) {

        } finally {
            System.out.println(1987);
        }
    }
}
