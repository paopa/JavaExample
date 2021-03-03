package pers.pao.os.cli;

import java.io.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PythonExecuteTest {

    private final static String PATH = "";
    private final static List<String> LIST = List.of("d");

    public static void main(String[] args) throws Exception {
        ProcessBuilder pb = new ProcessBuilder("python3", "-u", "test.py");
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
        try (BufferedWriter out = generateOutputStream(outputStream)) {
            AtomicInteger i = new AtomicInteger();
            while (i.getAndIncrement() < 100000) {
                list.forEach(name -> {
                    try {
                        System.out.println("-----" + i.get());
                        out.write(name);
                        out.newLine();
                        out.flush();
                        System.out.println(name.getBytes().length);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedWriter generateOutputStream(OutputStream outputStream) {
        return new BufferedWriter(new OutputStreamWriter(outputStream));
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
            Thread.sleep(100);
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public BufferedReader generateReader(InputStream inputStream) {
        return new BufferedReader(new InputStreamReader(inputStream));
    }
}