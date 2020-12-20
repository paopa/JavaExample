package pers.paopa.guava.collections.multimap;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        listTest();
        removeTest();
        asMapTest();
        keySetTest();
        valuesTest();
    }

    private static void valuesTest() {
        A a = new A();
        System.out.println("values of multi map");
        Collection<String> values = a.multimap.values();
        System.out.println(values);
    }

    private static void keySetTest() {
        A a = new A();
        System.out.println("keys of multi map");
        Set<String> keys = a.multimap.keySet();
        keys.forEach(System.out::println);
    }

    private static void asMapTest() {
        A a = new A();
        Map<String, Collection<String>> map = a.multimap.asMap();
        System.out.println("multi as a map");
        map.entrySet().forEach(set -> {
            String key = set.getKey();
            Collection<String> value = map.get(key);
            System.out.println(key + ":" + value);
        });
    }

    private static void removeTest() {
        A a = new A();
        Multimap<String, String> map = a.multimap;
        List<String> list = (List<String>) map.get("upper");
        System.out.println("initial upper case list");
        System.out.println(list);
        list.remove("D");
        System.out.println("modified upper case list");
        System.out.println(list);
    }

    private static void listTest() {
        A a = new A();
        Multimap<String, String> map = a.multimap;
        List<String> list = (List<String>) map.get("lower");
        System.out.println("initial lower case list");
        System.out.println(list);
    }
}

class A {

    Multimap<String, String> multimap = ArrayListMultimap.create();

    public A() {
        // lower case
        multimap.put("lower", "a");
        multimap.put("lower", "b");
        multimap.put("lower", "c");
        multimap.put("lower", "d");
        multimap.put("lower", "e");
        // upper case
        multimap.put("upper", "A");
        multimap.put("upper", "B");
        multimap.put("upper", "C");
        multimap.put("upper", "D");

    }
}
