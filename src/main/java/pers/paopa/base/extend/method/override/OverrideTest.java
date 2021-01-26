package pers.paopa.base.extend.method.override;

public class OverrideTest {
    public static void main(String[] args) {
//        demoA();
//        demoB();
        demoC();
    }

    private static void demoC() {
        A a = new B();
        System.out.println(a.getResult());
    }

    private static void demoB() {
        B b = new B();
        System.out.println(b.getResult());
    }

    private static void demoA() {
        A a = new A();
        System.out.println(a.getResult());
    }
}

class A {

    private int i = 10;

    public int getResult() {
        return getI() + 10;
    }

    public int getI() {
        return i;
    }
}

class B extends A {

    private int i = 20;

    public int getResult() {
        return getI() + 20;
    }

    public int getI() {
        return i;
    }
}
