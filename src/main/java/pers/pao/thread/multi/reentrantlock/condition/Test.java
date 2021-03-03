package pers.pao.thread.multi.reentrantlock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        ReentrantLockThread1 lockThread1 = new ReentrantLockThread1(lock, condition);
        Thread thread1 = new Thread(lockThread1);
        thread1.start();

        ReentrantLockThread2 lockThread2 = new ReentrantLockThread2(lock, condition);
        Thread thread2 = new Thread(lockThread2);
        thread2.start();
    }
}
