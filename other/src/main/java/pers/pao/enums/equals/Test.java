package pers.pao.enums.equals;

public class Test {
    public static void main(String[] args) {
        System.out.println("A".equals(E.A));
        System.out.println(E.valueOf("B").equals(E.B));
    }
}

enum E {
    A, B, C
}
