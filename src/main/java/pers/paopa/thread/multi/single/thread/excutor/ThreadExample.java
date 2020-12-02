package pers.paopa.thread.multi.single.thread.excutor;

import lombok.SneakyThrows;

public class ThreadExample implements Runnable {

    @SneakyThrows
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        Thread.sleep(1000);
        System.out.println("run " + name + " thread");
    }
}
