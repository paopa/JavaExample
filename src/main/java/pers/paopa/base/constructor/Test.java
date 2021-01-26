package pers.paopa.base.constructor;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(a.getName());
        A a1 = new A("david");
        System.out.println(a1.getName());
    }
}

class A {

    private String name;

    public A() {
        this("default");
    }

    public A(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}

