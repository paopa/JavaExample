package pers.paopa.thread.multi.executors.scheduled.thread.pool;

import lombok.SneakyThrows;

public class ThreadExample implements Runnable {

    private long lastTime;

    public ThreadExample(long lastTime) {
        this.lastTime = lastTime;
    }

    @SneakyThrows
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("run " + name + " thread, " + (System.currentTimeMillis() - lastTime));
        Thread.sleep(3000);
    }
}
