package pers.pao.classes.cast;

public class Test {
    public static void main(String[] args) {
        A a = new A();
        to1(a, Integer.class);
        to2(a);
    }

    public static <T> T to1(Object obj, Class<T> clazz) {
        try {
            return clazz.cast(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int to2(Object obj) {
        try {
            return (int) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}

class A {

}
