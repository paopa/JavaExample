package pers.pao.string.inflection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) {
//        test();
        inflectionTest();
    }

    /**
     * 藉由 inflection 的方式還是可以做到改變 String 內的值
     */
    @SneakyThrows
    private static void inflectionTest() {
        String val = "abc";
        Class cla = val.getClass();
        Field f = cla.getDeclaredField("value");
        f.setAccessible(true); // skip private validation
        byte[] bs = (byte[]) f.get(val);
        bs[1] = '#';
        System.out.println(val);
    }

    /**
     * String class 沒提供 改變本身 value method
     * 皆是產生新的 String
     */
    private static void test() {
        String s = " abc ";
        s.trim();
        System.out.println("!" + s + "!");
    }
}
