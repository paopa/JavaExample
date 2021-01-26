package pers.paopa.base.syntax;

/**
 * variable of abstract class is a normal field
 */
public class AbstractTest {
    public static void main(String[] args) {
        AB test = new B();
        System.out.println(test.x);
        test.x = "xxxx";
        System.out.println(test.x);
    }
}

class B extends AB{

}

abstract class AB {
    String x = "x";
}
