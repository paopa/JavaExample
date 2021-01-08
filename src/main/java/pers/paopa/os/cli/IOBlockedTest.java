package pers.paopa.os.cli;

import lombok.Builder;

import java.io.*;
import java.util.concurrent.atomic.AtomicLong;

public class IOBlockedTest {

    private final static String PATH = "";
    private final static String text = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
    private final static AtomicLong counter = new AtomicLong(0);

    @Builder
    static class IOStream {
        BufferedWriter out;
        BufferedReader in;
        BufferedReader error;
    }

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try {
            ProcessBuilder pb = new ProcessBuilder("python3", "-u", "-W", "ignore", "ioblock.py");
            pb.directory(new File(PATH));
            pb.redirectErrorStream(true);
            Process process = pb.start();
            IOStream stream = IOStream.builder()
                    .out(new BufferedWriter(new OutputStreamWriter(process.getOutputStream())))
                    .in(new BufferedReader(new InputStreamReader(process.getInputStream())))
                    .build();
            while (true) {
                send(stream.out);
                read(stream.in);
                Thread.sleep(3000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void send(BufferedWriter out) {
        try {
            System.out.println(counter.getAndIncrement());
            out.write(text);
            out.newLine();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void read(BufferedReader in) {
        try {
            String line = null;
            while (!in.ready()) {
                System.out.println("is readr ready ?" + in.ready());
            }
            while (in.ready()) {
                System.out.println("is readr ready ?" + in.ready());
                line = in.readLine();
                if (line == null) {
                    System.out.println("is null");
                    continue;
                }
                if (!line.startsWith("Y")) {
                    System.out.println("is not match prefix " + line);
                    continue;
                }
                System.out.println("is match prefix " + line);
            }
            System.out.println("is readr ready ?" + in.ready());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void error(BufferedReader error) {
        try {
            String line;
            while ((line = error.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
