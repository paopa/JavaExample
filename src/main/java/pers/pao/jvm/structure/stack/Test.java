package pers.pao.jvm.structure.stack;

/**
 * javap -v {Class}
 * 可以反編譯 .class file 成 bytecode
 *
 * e.g.
 *  stack=2, locals=4, args_size=1
 *          0: iconst_2
 *          1: istore_1
 *          2: iconst_3
 *          3: istore_2
 *          4: iload_1
 *          5: iload_2
 *          6: iadd
 *          7: istore_3
 *          8: return
 */
public class Test {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int c = a + b;
    }
}
