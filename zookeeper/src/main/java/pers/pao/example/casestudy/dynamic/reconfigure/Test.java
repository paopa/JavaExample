package pers.pao.example.casestudy.dynamic.reconfigure;

import java.io.IOException;

/**
 *
 */
public class Test {
    public static void main(String[] args) {
        new Thread(new ServerScenario()).start();
        new Thread(new ClientScenario()).start();
    }

    static final class ServerScenario implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    Thread thread = new Thread(new Server("1",3000));
                    Thread thread1 = new Thread(new Server("2",3000));
                    thread.start();
                    Thread.sleep(3000);
                    thread1.start();
                    Thread.sleep(10000);
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static final class ClientScenario implements Runnable {
        @Override
        public void run() {
            try {
                Thread thread1 = new Thread(new Client());
                thread1.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
