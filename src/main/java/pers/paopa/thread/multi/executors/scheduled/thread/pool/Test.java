package pers.paopa.thread.multi.executors.scheduled.thread.pool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        long lastTime = System.currentTimeMillis();

        // fixed rate 為設定間隔後啟動 若 thread 執行超過設定執行時間 則需要等到執行完後馬上執行
        service.scheduleAtFixedRate(new ThreadExample(lastTime), 1, 2, TimeUnit.SECONDS);

        // with fixed delay 為需等上個執行完成後才開始重新計數下一個 thread
//        service.scheduleWithFixedDelay(new ThreadExample(lastTime), 1, 2, TimeUnit.SECONDS);
    }
}
