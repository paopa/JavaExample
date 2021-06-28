package per.pao.practice.guava.string.caseformat;

import com.google.common.base.CaseFormat;

public class Test {
    public static void main(String[] args) {
        hyphenToCamelTest();
        underscoreToCamelTest();
        underscoreToUpperCamelTest();
    }

    private static void underscoreToUpperCamelTest() {
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));
    }

    private static void underscoreToCamelTest() {
        System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));
    }

    private static void hyphenToCamelTest() {
        System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));
    }
}
