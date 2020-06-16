package pers.paopa.text;

import java.io.UnsupportedEncodingException;

public class TextEncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\\xE7\\x84\\xA1\\xE6\\x95\\x88\\xE7\\x9A\\x84\\xE7\\x89\\xA9\\xE4\\xBB\\xB6\\xE5\\x90\\x8D\\xE7\\xA8\\xB1";
        String str2 = " 'information_schema.columns'";
        String str3 = "\\xE3\\x80\\x82";
        System.out.println(decoding(str) + str2 + decoding(str3));
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
