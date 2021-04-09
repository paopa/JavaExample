package pers.pao.collections.set;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        hashSet();
    }

    private static void hashSet() {
        Set set = new HashSet();
        System.out.println(set.add(1));
        System.out.println(set.add(1));
    }
}
