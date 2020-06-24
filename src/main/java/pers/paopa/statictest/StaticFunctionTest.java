package pers.paopa.statictest;

public class StaticFunctionTest {
    public static void main(String[] args) {
        NonStaticFunction.test();
    }
}

class NonStaticFunction {
    public static void test(){
        System.out.println(123);
    }
}
