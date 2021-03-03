package pers.pao.thread.multi.countdown;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch latch = new CountDownLatch(2);
        for (int i = 0; i < 5; i++) {
            service.execute(new CountDownThreadExample(latch));
            Thread.sleep(1000);
        }
        latch.await();
        System.out.println("thread running finish");
        service.shutdown();
    }
}
