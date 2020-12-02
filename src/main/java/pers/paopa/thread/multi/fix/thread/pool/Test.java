package pers.paopa.thread.multi.fix.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(5);
        try {
            for (int i = 0; i < 7; i++) {
                service.execute(new ThreadExample());
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            service.shutdown();
        }
    }
}
