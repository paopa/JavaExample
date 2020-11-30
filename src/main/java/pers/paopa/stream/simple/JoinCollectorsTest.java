package pers.paopa.stream.simple;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JoinCollectorsTest {
    public static void main(String[] args) {
        String x1 = Stream.of("c6", "c6")
                .filter(y -> false).collect(Collectors.joining(","));

        String x2 = Stream.of("c6", "c6")
                .filter(y -> false).collect(Collectors.joining(","));

        String z = Stream.of(x1,x2).filter(s-> !"".equals(s)).collect(Collectors.joining(","));
        System.out.println(z);
    }
}
