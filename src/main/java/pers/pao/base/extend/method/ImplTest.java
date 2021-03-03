package pers.pao.base.extend.method;

public class ImplTest {
    public static void main(String[] args) {
        A a = new C();
        System.out.println(C.class.getInterfaces().length);
        A a1 = new B();
        System.out.println(B.class.getInterfaces().length);
    }
}

interface A {
}

class B implements A {
}

class C extends B {
}