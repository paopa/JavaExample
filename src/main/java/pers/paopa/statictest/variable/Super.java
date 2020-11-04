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

    public static void test(){System.out.println("Super static method ");}
}

class Sub extends Super {

    static String sub1 = "static sub sub1";
    static String sub2 = "static sub sub2";

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
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Super.test();
        System.out.println(123);
        System.out.println(Super.s);

        System.out.println(456);
        System.out.println(new Sub());
//        classLoaderTest();
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
