package pers.paopa.thread.multi.cyclic;

import lombok.SneakyThrows;

import java.util.concurrent.CyclicBarrier;

public class CyclicThreadExample implements Runnable {

    private CyclicBarrier cyclicBarrier;

    public CyclicThreadExample(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @SneakyThrows
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("pre run thread, current thread is " + threadName);
        this.cyclicBarrier.await();
        System.out.println("finished thread, current thread is " + threadName);
    }
}
