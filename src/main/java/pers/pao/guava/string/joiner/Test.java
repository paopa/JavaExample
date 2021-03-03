package pers.pao.guava.string.joiner;

import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        skipNullTest();
        useForNullTest();
        appendToTest();
    }

    private static void appendToTest() {
        System.out.println(Joiner.on(",")
                .appendTo(new StringBuilder("head "), List.of("1", "2", "3").iterator()).toString());
    }

    private static void useForNullTest() {
        System.out.println(Joiner.on(",")
                .useForNull("NULL")
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }

    private static void skipNullTest() {
        System.out.println(Joiner.on(",")
                .skipNulls()
                .join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
    }
}
