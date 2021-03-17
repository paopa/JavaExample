package pers.pao.collections.retains;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(List.of("1", "2"));
        List<String> list2 = new ArrayList<>(List.of("1"));

        boolean b = list1.retainAll(list2);
        System.out.println(b);

    }
}
