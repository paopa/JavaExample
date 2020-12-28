package pers.paopa.string.encode;

import java.io.UnsupportedEncodingException;

public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String("我");
        byte[] bytes = s.getBytes("UTF-8");

        String current = new String(bytes, "ISO8859-1");
        System.out.println("error decode: " + current);

        String error = new String(bytes, "UTF-8");
        System.out.println("current decode: " + error);
    }
}
