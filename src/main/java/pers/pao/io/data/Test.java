package pers.pao.io.data;

import java.io.*;

public class Test {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        ProcessBuilder pb = new ProcessBuilder("python3", System.getProperty("user.dir")+"/src/main/java/pers/pao/io/resource/main.py");
        pb.redirectErrorStream(true);
        Process p = pb.start();
        InputStream in = p.getInputStream();
//        DataInputStream dis = new DataInputStream(in);
        int b;
        long start = System.currentTimeMillis();
        while((b = in.read()) != -1){
            System.out.print((char) b);
            if((char) b == ' '){
                System.out.println();
            }
//            Thread.sleep(500);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

}
