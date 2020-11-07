package pers.paopa.thread.multi.semaphore;

import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) {
        testSemaphore();
    }

    private static void testSemaphore() {
        Semaphore semaphore = new Semaphore(2);

        Thread thread1 = new Thread(new ThreadExample("thread1", semaphore));
        thread1.start();

        Thread thread2 = new Thread(new ThreadExample("thread2", semaphore));
        thread2.start();

        Thread thread3 = new Thread(new ThreadExample("thread3", semaphore));
        thread3.start();

        Thread thread4 = new Thread(new ThreadExample("thread4", semaphore));
        thread4.start();

        Thread thread5 = new Thread(new ThreadExample("thread5", semaphore));
        thread5.start();
    }

}
