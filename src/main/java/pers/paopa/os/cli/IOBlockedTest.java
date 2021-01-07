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
//                    .error(new BufferedReader(new InputStreamReader(process.getErrorStream())))
                    .build();
            while (true) {
                send(stream.out);
                read(stream.in);
//                Thread.sleep(1000);
//                error(stream.error);
            }
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

    private static void read(BufferedReader in) {
        try {
            String line = null;
//            label:
//            {
//                while (true) {
//                    while (in.ready()) {
//                        line = in.readLine();
//                        if (line != null && line.startsWith("Y")) {
//                            System.out.println(line);
//                            break label;
//                        }
//                    }
//                }
//            }
            while (in.ready()) {
                while ((line = in.readLine()) == null || !line.startsWith("Y")) {

                }
                break;
            }
            System.out.println(line);
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
}
