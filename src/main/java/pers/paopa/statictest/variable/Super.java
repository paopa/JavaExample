package pers.paopa.statictest.variable;

public class Super {
    static String s = "static super s";

    static {
        System.out.println("instance super class static");
    }

    {
        System.out.println("instance super class");
    }

    public Super() {
        System.out.println("instance Super constructor");
    }

    public static void test() {
        System.out.println("Super static method ");
    }
}

class Sub extends Super {

    static String sub1 = "static sub sub1";
    static String sub2 = "static sub sub2";
    final static String sub3 = "final static sub sub3";
    final static double sub4 = Math.random();

    static {
        System.out.println("instance sub class static");
    }

    {
        System.out.println("instance sub class");
    }

    public Sub() {
        System.out.println("instance Sub constructor");
    }
}

class Test {

    static {
        System.out.println("instance test class static");
    }

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
//        classLoaderTest();
    }

    /**
     * test instance two class
     */
    private static void test7() {
        System.out.println(new Sub());
        System.out.println(new Sub());
    }

    /**
     * test start main method flow
     */
    private static void test6() {
        System.out.println("test-6");
    }

    /**
     * test call final variable reference other class method
     */
    private static void test5() {
        System.out.println(Sub.sub4);
    }

    /**
     * test final prefix
     */
    private static void test4() {
        System.out.println(123);
        System.out.println(Sub.sub3);
    }

    /**
     * test call super class static variable
     */
    private static void test3() {
        System.out.println(Sub.s);
    }

    /**
     * test instance class
     */
    private static void test2() {
        System.out.println(new Sub());
    }

    /**
     * test call static variable
     */
    private static void test1() {
        System.out.println(Sub.sub1);
    }

    private static void classLoaderTest() throws ClassNotFoundException {
        Class c = Class.forName("pers.paopa.statictest.variable.Super");
        // 取得ClassLoader
        ClassLoader loader = c.getClassLoader();
        System.out.println(loader);
        // 取得父ClassLoader
        System.out.println(loader.getParent());
        // 再取得父ClassLoader
        System.out.println(loader.getParent().getParent());
    }
}
