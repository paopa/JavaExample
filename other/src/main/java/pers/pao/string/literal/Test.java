package pers.pao.string.literal;

/**
 * String literal vs String object
 * String literal stored at constant pool
 * String object will instance a object in heap
 */
public class Test {
    public static void main(String[] args) {
        String a = "asd";
        String b = "asd";
        String c = new String("asd");
        String d = c.intern();

        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
        System.out.println(b == c);
        System.out.println(c == d);

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a.equals(d));
        System.out.println(b.equals(c));
        System.out.println(c.equals(d));

    }

}
