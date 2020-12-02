package pers.paopa.thread.multi.executors.cache.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        try {
            for (int i = 0; i < 7; i++) {
                Thread.sleep(1);
                service.execute(new ThreadExample());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            service.shutdown();
        }
    }
}
