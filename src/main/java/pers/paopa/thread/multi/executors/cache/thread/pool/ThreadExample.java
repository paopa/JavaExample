package pers.paopa.thread.multi.executors.cache.thread.pool;

public class ThreadExample implements Runnable {
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("run " + name + " thread");
    }
}
