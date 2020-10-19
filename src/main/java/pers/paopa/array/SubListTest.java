package pers.paopa.array;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubListTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        List list = Stream.of("0", "1", "2", "3", "4", "5", "6").collect(Collectors.toList());
        List subList = list.subList(0, 3);
        System.out.println(subList);
        subList = list.subList(3, list.size());
        System.out.println(subList);
    }
}
