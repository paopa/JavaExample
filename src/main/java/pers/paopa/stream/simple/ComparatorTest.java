package pers.paopa.stream.simple;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ComparatorTest {
    public static void main(String[] args) {
        List list = Stream.of(2, 1)
                .sorted((o1, o2) -> (o1 > o2) ? -1 : 1)
                .collect(Collectors.toList());

        System.out.println(list);
    }
}
