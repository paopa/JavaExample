package pers.pao.guava.throwable;

import com.google.common.base.Throwables;

/**
 * 目前來看網路上的介紹文章，在 java 7 支援 multi-catch 後
 * guava 的 Throwables 就相較沒有其優勢，所以實際應用情境，
 * 看來主要是針對 java 6 及其之前版本，用處較為大。
 */
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