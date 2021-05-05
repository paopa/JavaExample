package pers.pao.thread.daemon;

import lombok.SneakyThrows;

public class Test {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (true) {
                    System.out.println("1");
                    Thread.sleep(100);
                }
            }
        });
        thread.setDaemon(false);
        thread.start();
    }
}
