package pers.pao.stream.finals.variable;

import lombok.Data;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        A a1 = new A();
        a1.setId(1);
//        a1 = new A();
        a1.setId(2);
        List.of(1, 2, 3).forEach(num -> {
            A a = new A();
            a.setId(a1.getId());
        });
    }
}

@Data
class A {
    private int id;
}
