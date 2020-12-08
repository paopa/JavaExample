package pers.paopa.file.simple.dir;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;

public class CreateDirTest {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("/17/144_f6bd260d-028d-46d7-ac04-2e8c268efb00/main.py");
        dirTraversal(path.getParent());
    }

    private static void dirTraversal(Path path) throws IOException {
        System.out.println(path);
        if (Files.exists(path)) {
            return;
        }
        dirTraversal(path.getParent());
        Files.createDirectory(path);
    }
}
