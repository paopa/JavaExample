package pers.paopa.base.inner;

public class InnerClassTest {
    public static void main(String[] args) {

         A a = new A();

         A.NonStatic an = a.new NonStatic();
        System.out.println(an.x);
        an.x = 100;
        System.out.println(an.x);


        A.Static as = new A.Static();
        System.out.println(as.xx);
        as.xx = 99;
        System.out.println(as.xx);
        A.Static as2 = new A.Static();
        System.out.println(as2.xx);
    }
}

class A{

    class NonStatic {
        public int x;
    }

    static class Static {
        public int xx;
    }

}
