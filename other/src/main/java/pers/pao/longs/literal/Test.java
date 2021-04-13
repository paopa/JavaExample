package pers.pao.longs.literal;

public class Test {
    public static void main(String[] args) {
        long i = 10;
        Long j = i;
        System.out.println(i);
        System.out.println(j);
        long[] longs = {i, j};
        System.out.println(longs[0] == i);
        System.out.println(longs[1] == j);

        Long[] longs1 = new Long[]{1L, 2L};
        System.out.println(longs1[0] == 1L);
        System.out.println(longs1[0] == new Long(1));
    }
}
