package pers.pao.jvm.stack.frame.dynamic.linking;

public class Test {

    private int i = 10;

    public void methodA() {
        System.out.println("methodA()....");
    }

    public void methodB() {
        System.out.println("methodB()....");

        methodA();

        i++;
    }
}
