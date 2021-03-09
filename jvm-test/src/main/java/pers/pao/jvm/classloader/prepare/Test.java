package pers.pao.jvm.classloader.prepare;

/**
 * 可以藉由
 * javap -p -v -constant -c file
 * 看出 static final 在 compile 就分配好值
 * 而 static 則是在 initial 才分配值
 */
public class Test {
    private static int a = 1;//prepare: a=0 ---> initial: a=1
    private static final int b = 3;

    public static void main(String[] args) {

    }
}
