package pers.pao.jvm.classloader.initialization;

/**
 * "<clinit>"
 * <p>
 * class init method
 * <p>
 * execution:
 * 1.pass value to static variable
 * 2.static{ ... }
 */
public class ClinitTest {
    private static int a = 1;

    static {
        a = 2;
        b = 20;
        System.out.println(a);
//        System.out.println(b);//illegal forward reference
//        System.out.println(Test.b);
    }

    // linking prepare: b=0 ---> initialization: 20 --> 10
    private static int b = 10;

    public static void main(String[] args) {
        System.out.println(ClinitTest.a);
        System.out.println(ClinitTest.b);
    }
}
