package pers.paopa.exception;

public class NFETest {
    public static void main(String[] args) {
        Double a = Double.parseDouble("-15.70");
        Double b = Double.parseDouble("-15.10");
        /*
        * Number Format Exception
        * because of '%'
        * */
//        Double c = Double.parseDouble("-15.10%");

        if (a > b)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
