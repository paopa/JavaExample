package pers.pao.base.extend.constractor;

public abstract class A {
    String a;

    public A(String a) {
        this.a = a;
    }

    public static class B extends A {
        public B(String a) {
            super(a);
        }

        @Override
        public String toString() {
            return "string a:" + super.a;
        }
    }

    public static void main(String[] args) {
        A a = new B("test");
        System.out.println(a);
    }
}
