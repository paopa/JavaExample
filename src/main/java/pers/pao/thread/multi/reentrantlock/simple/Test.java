package pers.pao.thread.multi.reentrantlock.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        demo();
    }

    private static void demo() throws InterruptedException {
        List<String> list = new ArrayList<>();
        LockThreadExample lock = new LockThreadExample(new ReentrantLock(), list);
        Thread t1 = new Thread(lock);
        Thread t2 = new Thread(lock);
        Thread t3 = new Thread(lock);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println(list.size());
    }
}
