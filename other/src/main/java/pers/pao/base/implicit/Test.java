package pers.pao.base.implicit;

/**
 * 從 .class file disassemble 來看
 * <p>
 * 同 data type a += b 與 a = a+b 一致
 * 不同 data type 會先將 a 轉成 b 的 data type
 * 做加總 在轉回 a 的 data type
 * <p>
 * a += b
 * 0: iload_0
 * 1: i2d
 * 2: dload_1
 * 3: dadd
 * 4: d2i
 * 5: istore_0
 * 6: return
 * <p>
 * a = a + (int) b
 * 0: iload_0
 * 1: dload_1
 * 2: d2i
 * 3: iadd
 * 4: istore_0
 * 5: return
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        double b = 1.1;
        test(a, b);
        test2(a, b);
    }

    private static void test2(int a, double b) {
        a += b;
    }

    private static void test(int a, double b) {
        a = a + (int) b;
    }
}
