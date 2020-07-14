package pers.paopa.text;

import java.io.UnsupportedEncodingException;

public class TextEncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String str = "\\xE4\\xBC\\xBA\\xE6\\x9C\\x8D\\xE5\\x99\\xA8\\xE4\\xB8\\xBB\\xE9\\xAB\\x94";
        String str2 = " jvx ";
        String str3 = "\\xE5\\x9C\\xA8\\xE7\\x9B\\xAE\\xE5\\x89\\x8D\\xE7\\x9A\\x84\\xE5\\xAE\\x89\\xE5\\x85\\xA8\\xE6\\x80\\xA7\\xE5\\x85\\xA7\\xE5\\xAE\\xB9\\xE4\\xB8\\x8B\\xE7\\x84\\xA1\\xE6\\xB3\\x95\\xE5\\xAD\\x98\\xE5\\x8F\\x96\\xE8\\xB3\\x87\\xE6\\x96\\x99\\xE5\\xBA\\xAB";
        String str4 = " COOLGAS ";
        String str5 = "\\xE3\\x80\\x82";
        String str6 = "";
        String str7 = "";
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
