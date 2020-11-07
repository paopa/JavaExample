package pers.paopa.thread.multi.semaphore;

import java.util.concurrent.Semaphore;

public class ThreadExample implements Runnable {

    private String threadName;
    private Semaphore semaphore;

    public ThreadExample(String threadName, Semaphore semaphore) {
        this.threadName = threadName;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            this.semaphore.acquire();
            Thread.sleep(1000);
            System.out.println("thread name is: " + threadName);
            this.semaphore.release();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
