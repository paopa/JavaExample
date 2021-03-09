package pers.pao.jvm.classloader.initialization;

public class SubSuperTest {
    public static void main(String[] args) {
        System.out.println(Sub.B);
    }

    static class Super {
        static int A = 1;

        static {
            A = 2;
        }
    }

    static class Sub extends Super {
        static int B = A;
    }
}
