package pers.pao.exception.scenario;

public class GetClass {
    public static void main(String[] args) {
        try{
            throw new ArrayStoreException("xx");
        }catch (Exception e){
            System.out.println(e.getClass());
        }
    }
}
