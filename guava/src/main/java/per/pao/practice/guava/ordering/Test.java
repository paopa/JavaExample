package per.pao.practice.guava.ordering;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        numberDemo(a);
        stringDemo(a);
    }

    private static void stringDemo(A a) {
        Ordering ordering = Ordering.natural();
        System.out.println("Another List: ");
        System.out.println(a.strings);
        a.strings.sort(ordering.nullsFirst().reverse());
        System.out.println("Null first then reverse sorted list: ");
        System.out.println(a.strings);
    }

    private static void numberDemo(A a) {
        Ordering ordering = Ordering.natural();
        System.out.println("Input List: ");
        System.out.println(a.numbers);

        a.numbers.sort(ordering);
        System.out.println("Sorted List: ");
        System.out.println(a.numbers);

        System.out.println("===============");
        System.out.println("List is sorted: " + ordering.isOrdered(a.numbers));
        System.out.println("Minimum: " + ordering.min(a.numbers));
        System.out.println("Maximum: " + ordering.max(a.numbers));

        a.numbers.sort(ordering.reverse());
        System.out.println("Reverse: " + a.numbers);

        a.numbers.add(null);
        System.out.println("Null first Sorted List: ");
        System.out.println(a.numbers);
        System.out.println("===============");

        a.numbers.sort(ordering.nullsFirst());
        System.out.println("NUll first Sorted List: ");
        System.out.println(a.numbers);
        System.out.println("===============");
    }

    static class A {
        List<Integer> numbers = generateNumbers();

        List<String> strings = generateStrings();

        private List<String> generateStrings() {
            List<String> list = new ArrayList<>();
            list.add("Aaa");
            list.add("Bs");
            list.add("Syn");
            list.add("Daa");
            list.add(null);
            list.add("Vik");
            list.add("Tee");
            return list;
        }


        private List<Integer> generateNumbers() {
            List<Integer> list = new ArrayList();
            list.add(5);
            list.add(2);
            list.add(3);
            list.add(123);
            list.add(4);
            list.add(1234);
            list.add(22);
            list.add(55);
            list.add(66);
            list.add(13);
            return list;
        }
    }
}
