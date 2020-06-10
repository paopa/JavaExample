package pers.paopa.exception;

public class TryCatch {
    public static void main(String[] args) {
        try{
            throwException("123");
        }catch (Exception e){
            throw e;
        }
    }

    private static void throwException(String s) {
    }
}
