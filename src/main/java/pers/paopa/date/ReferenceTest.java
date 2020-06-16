package pers.paopa.date;

/**
 * String Object wont change value at function
 * Self Declare Object will change value at function
 */
public class ReferenceTest {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        Long aLong = 10L;
        String a = "123";
        b b = new b();
        test(a, b, aLong);
        System.out.println(a);
        System.out.println(aLong);
        System.out.println(b.getC() + "&&" + b.getD());
    }

    private static void test(String a, b b, Long aLong) {
        a = a + "abc";
        aLong++;
        b.setC(99L);
        b.setD("david");
        System.out.println(a);
        System.out.println(aLong);
        System.out.println(b.getC() + "&&" + b.getD());
    }
}

class b {
    private Long c;
    private String d;

    public Long getC() {
        return this.c;
    }

    public void setC(Long c) {
        this.c = c;
    }

    public String getD() {
        return this.d;
    }

    public void setD(String d) {
        this.d = d;
    }
}