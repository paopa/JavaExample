package pers.pao.base.hash;

/**
 * @see java.util.HashMap#hash(Object)
 */
public class Test {
    public static void main(String[] args) {
        int h;
        Integer key = 16;
        h = key.hashCode();
        System.out.println("After hash: " + h);
        int a = (h >> 2);
        System.out.println("After bit-shift: " + a);
        int x = h ^ a;
        System.out.println("After xor: " + x);
    }
}
