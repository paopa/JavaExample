package pers.pao.classes;

import pers.pao.date.com.ConvertYearToACTest;

public class ClassTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        Class<?> classA = ConvertYearToACTest.class;
        System.out.println(classA.toGenericString()
        );
    }
}
