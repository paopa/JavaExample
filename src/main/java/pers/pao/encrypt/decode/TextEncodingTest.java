package pers.pao.encrypt.decode;

import java.io.UnsupportedEncodingException;

public class TextEncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\\xE3\\x80\\x82";
        System.out.println(decoding(str));
    }

    private static String decoding(String str) {
        try {
            byte[] bytes = new byte[str.length() / 4];

            for (int i = 0; i < str.length(); i += 4) {
                bytes[i / 4] = (byte) Integer.parseInt(str.substring(i + 2, i + 4), 16);
            }
            return new String(bytes, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
