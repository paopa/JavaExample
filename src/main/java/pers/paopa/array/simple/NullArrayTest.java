package pers.paopa.array.simple;

import java.util.stream.Stream;

public class NullArrayTest {
    public static void main(String[] args) {
        Double[] array  = new Double[3];
        array[0] = 1.2;
        Stream.of(array).forEach(System.out::println);
    }
}
