package pers.pao.jvm.stack.frame.operand.stack;

public class Test {

    public void test() {
        byte j = 10;
        int k = 20;
        int x = j + k;
    }

    public void a() {
        int a = 10;
        int b = b();
    }

    public int b() {
        int a = 10;
        int b = 10;
        return a + b;
    }

    /**
     * stack=2, locals=11, args_size=1
     * 0: bipush        10
     * 2: istore_1
     * 3: iinc          1, 1
     *
     * 6: bipush        10
     * 8: istore_2
     * 9: iinc          2, 1
     *
     * 12: bipush        10
     * 14: istore_3
     * 15: iload_3
     * 16: iinc          3, 1
     * 19: istore        4
     *
     * 21: bipush        10
     * 23: istore        5
     * 25: iinc          5, 1
     * 28: iload         5
     * 30: istore        6
     *
     * 32: bipush        10
     * 34: istore        7
     * 36: iload         7
     * 38: iinc          7, 1
     * 41: istore        7
     *
     * 43: bipush        10
     * 45: istore        8
     * 47: iinc          8, 1
     * 50: iload         8
     * 52: istore        8
     *
     * 54: bipush        10
     * 56: istore        9
     * 58: iload         9
     * 60: iinc          9, 1
     * 63: iinc          9, 1
     * 66: iload         9
     * 68: iadd
     * 69: istore        10
     *
     * 71: return
     */
    public void add() {
        // 1
        int i1 = 10;
        i1++;
        int i2 = 10;
        ++i2;

        // 2
        int i3 = 10;
        int i4 = i3++;

        int i5 = 10;
        int i6 = ++i5;

        // 3
        int i7 = 10;
        i7 = i7++;

        int i8 = 10;
        i8 = ++i8;

        // 4
        int i9 = 10;
        int i0 = i9++ + ++i9;
    }
}
