package pers.paopa.thread.multi.simple;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {
//        testExtendThread();
//        testImplementRunnable();
//        testSumThread();
        testArrayListThread();
    }

    /**
     * ArrayList、LinkedList、Map、HashMap、Set、HashSet 皆為執行緒不安全
     *
     * @throws InterruptedException
     */
    private static void testArrayListThread() throws InterruptedException {
        List<String> list = new ArrayList<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
//        Thread thread1 = new Thread(new ArrayListThreadTest(list));
//        Thread thread2 = new Thread(new ArrayListThreadTest(list));
//        Thread thread3 = new Thread(new ArrayListThreadTest(list));
        Thread thread1 = new Thread(new ArrayListSynThreadTest(list));
        Thread thread2 = new Thread(new ArrayListSynThreadTest(list));
        Thread thread3 = new Thread(new ArrayListSynThreadTest(list));
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("list size is " + list.size());
    }

    private static void testSumThread() throws InterruptedException {
        SumThread sum = new SumThread();
        Thread thread = new Thread(sum);
        thread.start();
        synchronized (thread) {
            thread.wait();
        }
        int result = sum.sum;
        System.out.println("count sum is: " + result);
    }

    private static void testImplementRunnable() {
        Thread thread1 = new Thread(new ThreadTest2("message1"));
        Thread thread2 = new Thread(new ThreadTest2("message2"));
        Thread thread3 = new Thread(new ThreadTest2("message3"));
        Thread thread4 = new Thread(new ThreadTest2("message4"));
        Thread thread5 = new Thread(new ThreadTest2("message5"));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }

    private static void testExtendThread() {
        ThreadTest1 thread1 = new ThreadTest1("message1");
        ThreadTest1 thread2 = new ThreadTest1("message2");
        ThreadTest1 thread3 = new ThreadTest1("message3");
        ThreadTest1 thread4 = new ThreadTest1("message4");
        ThreadTest1 thread5 = new ThreadTest1("message5");
        ThreadTest1 thread6 = new ThreadTest1("message6");
        ThreadTest1 thread7 = new ThreadTest1("message7");
        ThreadTest1 thread8 = new ThreadTest1("message8");
        ThreadTest1 thread9 = new ThreadTest1("message9");
        ThreadTest1 thread10 = new ThreadTest1("message10");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        thread7.start();
        thread8.start();
        thread9.start();
        thread10.start();
    }
}
