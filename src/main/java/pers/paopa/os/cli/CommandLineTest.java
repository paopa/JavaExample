package pers.paopa.os.cli;

import java.io.*;

public class CommandLineTest {
    public static void main(String[] args) {
        new CommandLineTest().demo();
    }

    private void demo() {
        try {
            String command = "";
            Process process = executeCommand(command);
            if (process != null) {
                BufferedReader reader = openBufferedReader(process);
                printAll(reader);
                process.waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printAll(BufferedReader reader) {
        reader.lines().forEach(System.out::println);
    }

    private BufferedReader openBufferedReader(Process process) {
        return new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    private Process executeCommand(String command) throws IOException {
        if ("".equals(command)) {
            return null;
        }
        return Runtime.getRuntime().exec(command);
    }
}
