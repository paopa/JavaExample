package pers.paopa.base.extend.method.override;

/**
 * 動態綁定機制：JVM 在執行對象成員方法時，會將這個方法和對象的實際內存進行綁定，然後調用
 * 動態綁定機制和變數沒有關係，指和方法有關係。
 */
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

//    public void print() {
//        System.out.println(a);
//    }
}

class x {
    String a = "213";

    public void print() {
        System.out.println(a);
    }
}
