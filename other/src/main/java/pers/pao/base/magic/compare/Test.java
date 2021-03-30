package pers.pao.base.magic.compare;

/**
 * disassemble .class file
 * 0: ldc2_w        #7                  // double 0.30000000000000004d
 * 3: dstore_1
 * 4: ldc2_w        #9                  // double 0.3d
 * a is not exactly 0.3
 */
public class Test {
    public static void main(String[] args) {
        double a = 3 * 0.1;
        double b = 0.3;
        System.out.println(a == b);
    }
}
