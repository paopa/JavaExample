package pers.paopa.thread.multi.semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) throws Exception {
//        testSemaphore();
        testCopyOnWriteArrayList();
    }

    private static void testCopyOnWriteArrayList() throws Exception {
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of("a1", "a2", "a3", "a4", "a5"));
        Thread thread = new Thread(new ThreadExample2(list));
        thread.start();

        list.forEach(element -> {
            try {
                Thread.sleep(10);
                System.out.println(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * test semaphore
     */
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
