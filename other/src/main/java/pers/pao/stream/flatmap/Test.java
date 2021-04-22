package pers.pao.stream.flatmap;

import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List.of(new A()).stream().map(a -> new B()).collect(Collectors.toList());
        List.of(new A()).stream().flatMap(a -> List.of(new B()).stream()).collect(Collectors.toList());
    }
}

class A {

}

class B {

}
