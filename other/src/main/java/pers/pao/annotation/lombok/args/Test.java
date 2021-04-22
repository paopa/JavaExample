package pers.pao.annotation.lombok.args;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Test {
    public static void main(String[] args) {

    }
}

@AllArgsConstructor
class A {
    int a;
    int b;
    int c;

    public A(int a, int b) {
        this(a, b, 0);
    }


}

@Data
class B {
    int a;
    int b;
    int c;

    public B(int a, int b) {
    }
}
