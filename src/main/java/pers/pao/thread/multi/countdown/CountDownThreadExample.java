package pers.pao.thread.multi.countdown;

import java.util.concurrent.CountDownLatch;

/**
 * 常被使用的情境在再啟動 service 時做的檢查，就可以開多個 thread
 * 進行 service initial 的部分，所有的檢查都正確時再往下的執行 service 其它的工作。
 *
 */
public class CountDownThreadExample implements Runnable {

    private CountDownLatch latch;

    public CountDownThreadExample(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.println("current thread: " + name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            latch.countDown();
        }
    }
}
