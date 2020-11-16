package pers.paopa.thread.multi.factory;

import java.util.concurrent.ThreadFactory;

public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        ThreadFactoryExample factory = new ThreadFactoryExample();

        Thread thread1 = factory.newThread(new ThreadExample("message-1"));
        Thread thread2 = factory.newThread(new ThreadExample("message-2"));
        Thread thread3 = factory.newThread(new ThreadExample("message-3"));

        System.out.println(factory.getCount());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
