package pers.pao.literal;

public class LongLiteral {
    public static void main(String[] args) {
        long i = 10;
        Long j = i;
        System.out.println(i);
        System.out.println(j);
        long[] longs = {i, j};
        System.out.println(longs[0] == i);
        System.out.println(longs[1] == j);
    }
}
