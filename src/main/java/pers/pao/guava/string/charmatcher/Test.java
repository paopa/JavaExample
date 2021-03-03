package pers.pao.guava.string.charmatcher;

import com.google.common.base.CharMatcher;

public class Test {
    public static void main(String[] args) {
        withSpaceTest();
        replaceFrom();
        orAndRetainFromTest();
    }

    private static void orAndRetainFromTest() {
        System.out.println(CharMatcher.anyOf("m")
                .or(CharMatcher.inRange('0', '9')).retainFrom("mahesh123"));
    }

    private static void replaceFrom() {
        System.out.println(CharMatcher.javaDigit().replaceFrom("mahesh123", "*"));
    }

    private static void withSpaceTest() {
        System.out.println(CharMatcher.whitespace()
                .trimAndCollapseFrom("Mahesh      Parashar ", ' '));
    }
}
