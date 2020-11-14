package pers.paopa.thread.multi.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ReentrantLockThread1 implements Runnable {

    private Lock lock;
    private Condition condition;

    public ReentrantLockThread1(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            this.lock.lock();
            System.out.println("run thread 1-1");
            this.condition.await();
            System.out.println("run thread 1-2");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            this.lock.unlock();
        }
    }
}
