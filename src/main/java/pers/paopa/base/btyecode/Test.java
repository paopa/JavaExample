package pers.paopa.base.btyecode;

/**
 * 在 byte code 中會看到這樣的操作
 * 1) _a = i++; => _a = 0;i = 1
 * 2) i = _a = 0
 * <p>
 * 可以在 .class file 中看到類似的操作
 */
public class Test {
    public static void main(String[] args) {
//        demo1();
        demo2();
    }

    private static void demo2() {
        int i = 0;
        int j = i++;
        System.out.println(i);
        System.out.println(j);
    }

    private static void demo1() {
        int i = 0;
        i = i++;
        System.out.println(i);
    }
}
