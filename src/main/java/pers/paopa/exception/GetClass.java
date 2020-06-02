package pers.paopa.exception;

public class GetClass {
    public static void main(String[] args) {
        try{
            throw new ArrayStoreException("xx");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
