package pers.pao.thread.multi.countdown.timer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                latch.await(3, TimeUnit.SECONDS);
//                latch.await();
                System.out.println(Thread.currentThread().getName() + " end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start");
            latch.countDown();
            System.out.println(Thread.currentThread().getName() + " end");
        }).start();
    }
}


