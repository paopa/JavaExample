package pers.pao.stream.flatmap.combine;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test
{
    public static void main(String[] args)
    {
        test1();
    }

    private static void test1()
    {
        Stream.of(1)
                .flatMap(x -> Stream.of(
                        List.of(1, 2, 3, 4).stream(),
                        List.of(5, 6, 7, 8).stream()
                ))
                .flatMap(Function.identity())
                .forEach(System.out::println);
    }
}
