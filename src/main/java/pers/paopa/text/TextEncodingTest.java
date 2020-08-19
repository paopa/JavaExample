package pers.paopa.text;

import java.io.UnsupportedEncodingException;

public class TextEncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\\xE5\\xAD\\x97\\xE4\\xB8\\xB2\\xE6\\xA0\\xBC\\xE5\\xBC\\x8F\\xE4\\xB8\\x8D\\xE5\\x90\\x88\\xE6\\xB3\\x95";
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
