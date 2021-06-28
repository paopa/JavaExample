package per.pao.practice.guava.range;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

public class Test {
    public static void main(String[] args) {
//        demo();
//        demo2();
//        demo3();
//        demo4();
//        demo5();
//        demo6();
//        demo7();
//        demo8();
        demo9();
    }

    private static void demo9() {
        Range<Integer> range1 = Range.closed(0, 9);
        Range<Integer> range2 = Range.closed(5, 15);
        printRange(range1.intersection(range2));
        printRange(range1.span(range2));
    }

    private static void demo8() {
        Range<Integer> range1 = Range.closed(0, 9);
        Range<Integer> range2 = Range.closed(9, 20);
        printRange(range2);
        System.out.println("[0,9] is connected [9,20]: " + range1.isConnected(range2));
    }

    private static void demo7() {
        Range<Integer> range1 = Range.closed(0, 9);
        Range<Integer> range2 = Range.closed(3, 5);
        System.out.println("[0,9] encloses [3,5]: " + range1.encloses(range2));
    }

    private static void demo6() {
        Range<Integer> range = Range.closed(3, 5);
        printRange(range);
    }

    private static void demo5() {
        Range<Integer> range = Range.greaterThan(9);
        System.out.println("(9,infinity) : ");
        System.out.println("Lower Bound: " + range.lowerEndpoint());
        System.out.println("Upper Bound present: " + range.hasUpperBound());
    }

    private static void demo4() {
        Range<Integer> range = Range.closedOpen(0, 9);
        System.out.print("[0,9]: ");
        printRange(range);
    }

    private static void demo3() {
        Range<Integer> range = Range.openClosed(0, 9);
        System.out.print("[0,9]: ");
        printRange(range);
    }

    private static void demo2() {
        Range<Integer> range = Range.open(0, 9);
        System.out.print("[0,9]: ");
        printRange(range);
    }

    private static void demo() {
        Range<Integer> range = Range.closed(0, 9);
        System.out.print("[0,9]: ");
        printRange(range);
        System.out.println("5 is present " + range.contains(5));
        System.out.println("(1,2,3) is present: " + range.containsAll(Ints.asList(1, 2, 3)));
        System.out.println("Lower Bound: " + range.lowerEndpoint());
        System.out.println("Upper Bound: " + range.upperEndpoint());
    }

    public static void printRange(Range<Integer> range) {
        System.out.print("[ ");
        for (int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade + " ");
        }
        System.out.println("]");
    }

}
