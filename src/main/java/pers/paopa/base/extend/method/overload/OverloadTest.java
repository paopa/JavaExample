package pers.paopa.base.extend.method.overload;

/**
 * 從範例來看 method overload parameter
 * 是依照 variable type 來看使用哪個方法
 * 當沒有該方法 instance 哪個
 */
public class OverloadTest {
    public static void main(String[] args) {
//        aTest();
//        bTest();
        parentTest();
    }

    private static void parentTest() {
        A a = new B();
        print(a);
    }

    private static void bTest() {
        B b = new B();
        print(b);
    }

    private static void aTest() {
        A a = new A();
        print(a);
    }

    public static void print(A a) {
        System.out.println("A");
    }

    public static void print(B b) {
        System.out.println("B");
    }
}

class A {

}

class B extends A {

}