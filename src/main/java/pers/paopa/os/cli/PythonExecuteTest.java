package pers.paopa.os.cli;

import java.io.*;
import java.util.List;

public class PythonExecuteTest {

    private final static String PATH = "";
    private final static List<String> LIST = List.of("d", "v", "g", "G", "x", "r", "r");

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
        try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            list.forEach(name -> {
                try {
                    out.write(name);
                    out.newLine();
                    out.flush();
                    System.out.println("-----");
                    Thread.sleep(1000);
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
            String line;
            while ((line = reader.readLine()) != null) {    //若檔案內容不為null就執行
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader generateReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}