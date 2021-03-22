package pers.pao.jvm.stack.frame;

/**
 * 利用 javap 進行 disassemble byte code
 * 來觀察 stack frame
 * <p>
 * method 結束方式分為兩種
 * 正常結束 return
 * method 中出現未 catch 的 exception 以拋出 exception 方式結束
 */
public class Test {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("main method end");
    }

    private static void method1() {
        System.out.println("method1 start");
        method2();
        System.out.println("method1 end");
//        System.out.println(10 / 0);
    }

    private static int method2() {
        System.out.println("method2 start");
        int i = 10;
        double v = method3();
        System.out.println("method2 will end");
        return i + (int) v;
    }

    private static double method3() {
        System.out.println("method3 start");
        double j = 20.0;
        System.out.println("method3 will end");
        return j;
    }
}
