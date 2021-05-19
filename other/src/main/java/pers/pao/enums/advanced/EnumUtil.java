package pers.pao.enums.advanced;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EnumUtil {
    public static <T extends java.lang.Enum<T>,
            F extends java.util.function.Function<String, String>> T valueOf(String s,
                                                                             String delimiter,
                                                                             Delimiter targetDelimiter,
                                                                             Class<T> clazz,
                                                                             F function) {
        return java.lang.Enum.valueOf(
                clazz,
                Arrays.stream(s.split(delimiter)).map(function).collect(Collectors.joining(targetDelimiter.getSign()))
        );
    }

    @RequiredArgsConstructor
    public enum Delimiter {
        DOLLAR_SIGN("$"), UNDER_SCORE("_");

        @Getter
        private final String sign;
    }
}

@Getter
@RequiredArgsConstructor
enum EnumA {
    A_A("a"), B_B("b"), C_C("c");

    private final String p1;

    public static EnumA valueOf(String s, String delimiter) {
        return EnumUtil.valueOf(s, delimiter, EnumUtil.Delimiter.UNDER_SCORE, EnumA.class, String::toUpperCase);
    }
}

@Getter
@RequiredArgsConstructor
enum EnumB {
    a$a("a"), b$b("b"), c$c("c");

    private final String p1;

    public static EnumB valueOf(String s, String delimiter) {
        return EnumUtil.valueOf(s, delimiter, EnumUtil.Delimiter.DOLLAR_SIGN, EnumB.class, String::toLowerCase);
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(EnumA.valueOf("A-A_A", "-A_"));
        System.out.println(EnumA.valueOf("A-A", "-"));
        System.out.println(EnumB.valueOf("a-a-", "-"));
    }
}