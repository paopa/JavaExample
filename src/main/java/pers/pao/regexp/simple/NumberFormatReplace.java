package pers.pao.regexp.simple;

import java.util.regex.Pattern;

public class NumberFormatReplace {
    public static void main(String[] args) {
        String longString = "(638,486,831)";
        String doubleString = "(-15.10%)";
        String longStringAfterFilter = filterLongString(longString);
        System.out.println(Long.valueOf(longStringAfterFilter));
        String doubleStringAfterFilter = filterDoubleString(doubleString);
        System.out.println(Double.valueOf(doubleStringAfterFilter));
    }

    private static String filterDoubleString(String doubleString) {
        String doubleStringAfterFilter = doubleString
                .replaceAll(",|%|\\(|\\)", "");
        return doubleStringAfterFilter;
    }

    private static String filterLongString(String longString) {
        String longStringAfterFilter = longString
                .replaceAll(",|%|\\(|\\)", "");
        return longStringAfterFilter;
    }

    public static class StringRegexTest {
        public static void main(String[] args) {
            boolean b = exec(" ");
            System.out.println(b);
        }

        private final static Pattern INTRODUCTION_PATTERN = Pattern.compile("(" +
                "^(?:介绍|关于|列出)?(?:资料|数据|信息)[库集源]?(?:的?(?:介绍|内容|概况|列表))?$)|^(\\ *)$");

        private static boolean exec(String s) {
            return INTRODUCTION_PATTERN.matcher(s).find();
        }
    }
}
