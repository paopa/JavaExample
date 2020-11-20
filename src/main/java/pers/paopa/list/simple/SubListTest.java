package pers.paopa.list.simple;

import java.util.List;

public class SubListTest {
    public static void main(String[] args) {
        List x = List.of("a", "b", "c").subList(0, 1);
        System.out.println(x);
    }
}
