package pers.paopa.regex;

import java.util.regex.Pattern;

public class StringRegexTest {
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
