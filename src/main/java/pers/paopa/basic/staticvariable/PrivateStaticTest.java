package pers.paopa.basic.staticvariable;

public class PrivateStaticTest {
    public static void main(String[] args) {
        A a = new A();
        a.print(12);
    }
}

class A {
    private static final String a = "test";

    public void print(int i) {
        System.out.println(a + i);
    }

    public void print2(){
        System.out.println(a);
    }
}
