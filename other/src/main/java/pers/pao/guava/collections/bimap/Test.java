package pers.pao.guava.collections.bimap;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Test {
    public static void main(String[] args) {
//        putTest();
//        duplicateTest();
        inverseTest();
    }

    private static void inverseTest() {
        A a = new A();
        a.map.inverse().put("AAA", 104);
        System.out.println(a.map.get(104));
    }

    private static void duplicateTest() {
        A a = new A();
        a.map.put(104, "Sohan");
        System.out.println(a.map.inverse().get("Sohan"));
    }

    private static void putTest() {
        A a = new A();
        System.out.println(a.map.inverse().get("Mahesh"));
    }
}

class A {
    BiMap<Integer, String> map = HashBiMap.create();

    public A() {
        map.put(101, "Mahesh");
        map.put(102, "Sohan");
        map.put(103, "Ramesh");
    }
}
