package pers.pao.jvm.parent.delegation.mechaism;

public class Test {
    public static void main(String[] args) {
        String s = new String();
        System.out.println("123");

        Test test = new Test();
        System.out.println(test.getClass().getClassLoader());
    }
}
