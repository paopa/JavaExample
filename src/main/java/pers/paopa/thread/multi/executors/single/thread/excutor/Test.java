package pers.paopa.thread.multi.executors.single.thread.excutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            for (int i = 0; i < 7; i++) {
                service.execute(new ThreadExample());
            }
        } catch (Exception e) {
            throw new RuntimeException();
        } finally {
            service.shutdown();
        }
    }
}
