package pers.paopa.text;

import java.io.UnsupportedEncodingException;

public class TextEncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\\xE9\\x99\\xA4\\xE9\\x9D\\x9E\\xE5\\x90\\x8C\\xE6\\x99\\x82\\xE6\\x8C\\x87\\xE5\\xAE\\x9A\\xE4\\xBA\\x86";
        String str2 = " TOP ";
        String str3 = "\\xE6\\x88\\x96";
        String str4 = " FOR XML ";
        String str5 = "\\xEF\\xBC\\x8C\\xE5\\x90\\xA6\\xE5\\x89\\x87";
        String str6 = "ORDER BY";
        String str7 = "\\xE5\\xAD\\x90\\xE5\\x8F\\xA5\\xE5\\x9C\\xA8\\xE6\\xAA\\xA2\\xE8\\xA6\\x96\\xE8\\xA1\\xA8\\xE3\\x80\\x81\\xE5\\x85\\xA7\\xE5\\xB5\\x8C\\xE5\\x87\\xBD\\xE6\\x95\\xB8\\xE3\\x80\\x81\\xE8\\xA1\\x8D\\xE7\\x94\\x9F\\xE8\\xB3\\x87\\xE6\\x96\\x99\\xE8\\xA1\\xA8\\xE3\\x80\\x81\\xE5\\xAD\\x90\\xE6\\x9F\\xA5\\xE8\\xA9\\xA2\\xE5\\x8F\\x8A\\xE9\\x80\\x9A\\xE7\\x94\\xA8\\xE8\\xB3\\x87\\xE6\\x96\\x99\\xE8\\xA1\\xA8\\xE9\\x81\\x8B\\xE7\\xAE\\x97\\xE5\\xBC\\x8F\\xE4\\xB8\\xAD\\xE5\\x9D\\x87\\xE7\\x82\\xBA\\xE7\\x84\\xA1\\xE6\\x95\\x88\\xE3\\x80\\x82";
        System.out.println(decoding(str) + str2 + decoding(str3) + str4 + decoding(str5) + str6 + decoding(str7));
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
