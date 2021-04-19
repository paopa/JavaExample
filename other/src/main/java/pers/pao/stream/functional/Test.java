package pers.pao.stream.functional;

public class Test {
    public static void main(String[] args) {
        A a1 = new A() {
            @Override
            public void display() {
                System.out.println("inner class");
            }
        };
        a1.display();

        A a2 = () -> System.out.println("lambda expression");
        a2.display();
    }
}

@FunctionalInterface
interface A {
    void display();
}
