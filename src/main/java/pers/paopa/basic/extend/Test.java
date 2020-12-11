package pers.paopa.basic.extend;

public class Test {
    public static void main(String[] args) {
        x x = new y();
        x.print();
    }
}

class z extends x {
    String a = "456";
}

class y extends x {
    String a = "789";

    public void print() {
        System.out.println(a);
    }
}

class x {
    String a = "213";

    public void print() {
        System.out.println(a);
    }
}
