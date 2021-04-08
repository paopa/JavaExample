package pers.pao.thread.lock;

import lombok.SneakyThrows;

import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {
    public static void main(String[] args) {
//        test(new A());
        test(new B());
//        test(new C());
    }

    private static void test(Runnable runnable) {
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

class A implements Runnable {

    private int count = 100;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName() + " a:" + count);
                count--;
            } else {
                break;
            }
        }
    }
}

class B implements Runnable {

    private int count = 100;

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (count > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " a:" + count);
                    count--;
                } else {
                    break;
                }
            }
        }
    }
}

class C implements Runnable {
    private int count = 100;
    private final ReentrantLock lock = new ReentrantLock();

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (count > 0) {
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName() + " a:" + count);
                    count--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }
}