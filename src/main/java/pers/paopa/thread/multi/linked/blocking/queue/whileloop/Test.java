package pers.paopa.thread.multi.linked.blocking.queue.whileloop;

import lombok.Data;
import lombok.SneakyThrows;

import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        new Thread(new A(queue)).start();
        new Thread(new B(queue)).start();
    }
}

@Data
class A implements Runnable {

    private final LinkedBlockingQueue<String> queue;

    @SneakyThrows
    @Override
    public void run() {
        int i = 0;
        while (true) {
            queue.add(String.valueOf(i));
            i++;
            Thread.sleep(2000);
        }
    }
}

@Data
class B implements Runnable {

    private final LinkedBlockingQueue<String> queue;

    @SneakyThrows
    @Override
    public void run() {
        String value;
        while (true) {
            while ((value = queue.take()) == null) {
                System.out.println("temp");
            }
            System.out.println("output: " + value);
        }
    }
}
