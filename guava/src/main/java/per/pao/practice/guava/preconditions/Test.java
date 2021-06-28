package per.pao.practice.guava.preconditions;

import com.google.common.base.Preconditions;

public class Test {
    public static void main(String[] args) {
        A a = new A();

        try {
            System.out.println(a.sqrt(-3));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(a.sum(null, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(a.getValue(5));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class A {
        public double sqrt(double input) {
            Preconditions.checkArgument(input > 0.0,
                    "Illegal Argument passed: Negative value %s.", input);
            return Math.sqrt(input);
        }

        public int sum(Integer a, Integer b) {
            a = Preconditions.checkNotNull(a,
                    "Illegal Argument passed: First parameter is Null.");
            b = Preconditions.checkNotNull(b,
                    "Illegal Argument passed: Second parameter is Null.");
            return a + b;
        }

        public int getValue(int input) {
            int[] data = {1, 2, 3, 4, 5};
            Preconditions.checkElementIndex(input, data.length,
                    "Illegal Argument passed: Invalid index.");
            return data[input];
        }
    }
}
