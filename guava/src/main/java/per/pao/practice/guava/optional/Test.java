package per.pao.practice.guava.optional;

import com.google.common.base.Optional;

public class Test {

    public static void main(String[] args) {
        Guava test = new Guava();
        Optional<Integer> a = Optional.fromNullable(null);
        Optional<Integer> b = Optional.of(10);
        System.out.println("sum is " + test.sum(a, b));
    }

    private static class Guava {
        public int sum(Optional<Integer> a, Optional<Integer> b) {

            System.out.println("a: " + a.isPresent());
            System.out.println("b: " + b.isPresent());

            int aa = a.or(0);
            int bb = b.get();
            return aa + bb;
        }
    }
}
