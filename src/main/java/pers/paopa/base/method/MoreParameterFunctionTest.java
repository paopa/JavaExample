package pers.paopa.base.method;

public class MoreParameterFunctionTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        print("1","de");
    }

    private static void print(String... value) {
        System.out.println(value[1]);
    }
}
