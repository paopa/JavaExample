package pers.paopa.basic.staticvariable;

public class InnerClassTest {

    {
        System.out.println("class test static");
    }

    public InnerClassTest() {
        System.out.println("class test");
    }

    public static class A {

        {
            System.out.println("inner class A static ");
        }

        public A() {
            System.out.println("inner class A");
        }

        public static Integer test(){
            return 1;
        }

    }
}

class TTT {
    public static void main(String[] args) {
        System.out.println(InnerClassTest.A.test());
    }
}
