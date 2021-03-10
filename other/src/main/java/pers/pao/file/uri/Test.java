package pers.pao.file.uri;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.dir") + "/src/main/java/pers/pao/file/uri/test.txt");
        Path path = Paths.get(file.toURI());
        System.out.println(path.getParent());
    }
}
