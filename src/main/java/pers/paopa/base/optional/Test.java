package pers.paopa.base.optional;

import lombok.Getter;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Optional<A> a = Optional.of(null);
        System.out.println(a.orElseThrow().getA());
    }
}

@Getter
class A{
    private String a = "A";
}
