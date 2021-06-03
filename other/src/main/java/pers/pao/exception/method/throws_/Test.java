package pers.pao.exception.method.throws_;

public class Test {
    public static void main(String[] args) {
        try {
            test();
        } catch (AException ex) {
            System.out.println("AException catch block");
            ex.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }

    public static void test() throws AException {
        throw new BException();
    }
}

class AException extends Exception {

}

class BException extends RuntimeException {

}