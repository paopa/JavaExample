package pers.pao.jvm.stack.frame.binding.invoke.dynamic;

public class Test {
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        Func func = s -> System.out.println(s + " declare a type Func variable");
        lambda.test("test1", func);
        lambda.test("test2", s -> System.out.println(s + " implement in method parameter"));
    }
}

@FunctionalInterface
interface Func {
    void test(String s);
}

class Lambda {
    public void test(String s, Func func) {
        func.test(s);
    }
}