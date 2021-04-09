package pers.pao.stream.map;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        Map<Integer, A> collect = List.of(new A(1, 2), new A(1, 3), new A(1, 4))
                .stream()
                .collect(Collectors.toMap(A::getA1, Function.identity(), (a1, a2) -> (a2)));
        System.out.println(collect);
    }
}

@Data
class A {
    private final int a1;
    private final int a2;
}