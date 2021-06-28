package per.pao.practice.guava.string.splitter;

import com.google.common.base.Splitter;

public class Test {

    final static String string = "the ,quick, , brown      ,fox ,      jumps, over, the, lazy, little dog.";
    final static String string1 = "123456789";
    final static String string2 = "  1  ,  2  ,  3  ,  4  ";

    public static void main(String[] args) {
//        simpleTest();
//        fixLengthTest();
        limitTest();
    }

    private static void limitTest() {
        System.out.println(Splitter.on(',').limit(3).trimResults().split(string2));
    }

    private static void fixLengthTest() {
        System.out.println(Splitter.fixedLength(3).split(string1));
    }

    private static void simpleTest() {
        System.out.println(Splitter.on(',')
                .trimResults()
                .omitEmptyStrings()
                .split(string));
    }
}
