package pers.paopa.base.constructor;

public class Test {
    public static void main(String[] args) {

    }
}

class A {

    private int num;

    public A() {
        this(0);
    }

    public A(int i) {
        this.num = i;
    }
}

