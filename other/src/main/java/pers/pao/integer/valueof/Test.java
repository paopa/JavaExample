package pers.pao.integer.valueof;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test
{
    // using cast to check the type of object is correct
    public static void main(String[] args)
    {
        final Stream<Object> stream1 = List.of(1, "2").stream().map(s -> s);
        final Stream<Object> stream2 = List.of(1, "2").stream().map(s -> s);

        final List<Integer> collect1 = stream1.map(s -> Integer.valueOf(s.toString())).collect(Collectors.toList());
        final List<Integer> collect2 = stream2.map(s -> (Integer) s).collect(Collectors.toList());
    }
}
