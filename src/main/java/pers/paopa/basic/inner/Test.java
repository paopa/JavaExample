package pers.paopa.basic.inner;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        TestA testA = test.test();
        System.out.println(testA.a);
    }

    public TestA test() {
        return new Test.TestA();
    }

    private class TestA {
        String a = "123";
    }
}
