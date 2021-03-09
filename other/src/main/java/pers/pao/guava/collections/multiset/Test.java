package pers.pao.guava.collections.multiset;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

import java.util.Iterator;
import java.util.Set;

/**
 * MultiSet 無序但可重複的一種 collection
 */
public class Test {
    public static void main(String[] args) {
        specificElementCountTest();
        totalSizeTest();
        asSetTest();
        usingIterator();
        displayOccurrenceTest();
        removeElementTest();
    }

    private static void removeElementTest() {
        A a = new A();
        a.set.remove("b", 2);
        System.out.println("Occurrence of 'b' : " + a.set.count("b"));
    }

    private static void displayOccurrenceTest() {
        A a = new A();
//        a.set.forEachEntry((s, v) -> System.out.println("Element: " + s + " occurrence: " + v));
        a.set.entrySet().forEach(
                (s) -> System.out.println("Element: " + s.getElement() + " occurrence: " + s.getCount()));
    }

    private static void usingIterator() {
        A a = new A();
        Iterator<String> iterator = a.set.iterator();
        StringBuilder sb = new StringBuilder("[");
        while (iterator.hasNext()) {
            sb.append(" ").append(iterator.next()).append(" ");
        }
        sb.append("]");
        System.out.println("iterator: " + sb.toString());
    }

    private static void asSetTest() {
        A a = new A();
        Set<String> set = a.set.elementSet();
        System.out.println("as set: " + set.toString());
    }

    private static void totalSizeTest() {
        A a = new A();
        System.out.println("Total size: " + a.set.size());
    }

    private static void specificElementCountTest() {
        A a = new A();
        System.out.println("Occurrence of 'b' : " + a.set.count("b"));
    }
}

class A {
    Multiset<String> set = HashMultiset.create();

    public A() {
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("b");
        set.add("b");
    }
}
