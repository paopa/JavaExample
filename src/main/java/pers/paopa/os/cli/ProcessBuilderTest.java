package pers.paopa.os.cli;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class ProcessBuilderTest {

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("ls", "-l");
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        reader.lines().forEach(System.out::println);
    }
}
