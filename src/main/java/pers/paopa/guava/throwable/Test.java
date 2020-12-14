package pers.paopa.guava.throwable;

import com.google.common.base.Throwables;

public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try {
            showCaseThrowable();
        } catch (InvalidInputException e) {
            System.out.println(Throwables.getRootCause(e));
        } catch (Exception e) {
            System.out.println(Throwables.getStackTraceAsString(e));
        }
    }

    private static void showCaseThrowable() throws InvalidInputException {
        try {
            sqrt(-3.0);
        } catch (Throwable e) {
            Throwables.propagateIfPossible(e, InvalidInputException.class);
        }
    }

    private static double sqrt(double v) throws InvalidInputException {
        if (v < 0) throw new InvalidInputException();
        return Math.sqrt(v);
    }

}

class InvalidInputException extends Exception {
}