package pers.pao.thread.base;

import lombok.SneakyThrows;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Thread.currentThread().getName() + " thread start");
        Object lock = new Object();
        Thread thread = new Thread(new A(lock),"w1");
        Thread thread1 = new Thread(new A(lock),"w2");
        Thread thread2 = new Thread(new B(lock),"n1");

        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread.join();
        System.out.println(Thread.currentThread().getName() + " thread end");
    }
}

class A implements Runnable {

    private Object obj;

    public A(Object obj) {
        this.obj = obj;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " in synchronized block");
        synchronized (obj) {
            System.out.println(Thread.currentThread().getName() + " start");
            obj.wait();
            System.out.println(Thread.currentThread().getName() + " end");
        }
        System.out.println(Thread.currentThread().getName() + " out synchronized block");
    }
}

class B implements Runnable {

    private Object obj;

    B(Object obj) {
        this.obj = obj;
    }

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " in synchronized block");
        synchronized (obj){
            System.out.println(Thread.currentThread().getName() + " start");
            System.out.println(Thread.currentThread().getName() + " end");
//            obj.notify();
            obj.notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " out synchronized block");
    }
}
