package pers.pao.stream.generate;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static void main(String[] args) {
        String[] a = {"1", "a", "2"};
        StreamSupport.stream(Arrays.stream(a).spliterator(), false)
                .forEach(System.out::println);

        Iterator<String> iterator = Arrays.stream(a).iterator();
        Stream.generate(() -> null)
                .takeWhile(x -> iterator.hasNext())
                .forEach(x -> System.out.println(iterator.next()));
    }
}
