package pers.paopa.classes;

import pers.paopa.date.ConvertYearToACTest;

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
