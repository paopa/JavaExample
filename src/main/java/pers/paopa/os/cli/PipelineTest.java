package pers.paopa.os.cli;

import java.io.*;
import java.util.List;

public class PipelineTest {

    private final static String PATH = "";
    private final static List<String> LIST = List.of("d\n", "v\n", "g\n", "G\n");

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python3", "test.py");
        pb.directory(new File(PATH));
        Process process = pb.start();
        new Thread(new Output(process.getOutputStream(), LIST)).start();
        new Thread(new Input(process.getInputStream())).start();
        new Thread(new Input(process.getErrorStream())).start();
        process.waitFor();
    }
}

class Output implements Runnable {

    private OutputStream outputStream;
    private List<String> list;

    public Output(OutputStream outputStream, List<String> list) {
        this.outputStream = outputStream;
        this.list = list;
    }

    @Override
    public void run() {
        try (OutputStream out = outputStream) {
            list.forEach(name -> {
                try {
                    out.write(name.getBytes());
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Input implements Runnable {
    private InputStream inputStream;

    public Input(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        try (BufferedReader reader = generateReader(inputStream)) {
            reader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader generateReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}