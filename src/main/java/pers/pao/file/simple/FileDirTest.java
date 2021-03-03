package pers.pao.file.simple;

import java.io.File;

public class FileDirTest {
    public static void main(String[] args) {
        File file = new File(args[0] + "/aaa/");
        file.exists();
    }
}
