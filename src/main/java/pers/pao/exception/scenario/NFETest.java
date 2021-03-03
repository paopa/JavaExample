package pers.pao.exception.scenario;

public class NFETest {
    public static void main(String[] args) {
//        doubleTest();
        longTest();
    }

    private static void longTest() {
        Long a = Long.valueOf("1,507,617,856");
        System.out.println(a);
    }

    private static void doubleTest() {
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
