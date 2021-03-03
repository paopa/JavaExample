package pers.pao.regexp.simple;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.CASE_INSENSITIVE;

public class RegexTest {

    public final static Pattern testPattern = Pattern.compile(
            "^(.*)$",
            CASE_INSENSITIVE);

    public static void main(String[] args) {
        String text = "";
        boolean x = testPattern.matcher(text).find();
        System.out.println(x);
    }
}
