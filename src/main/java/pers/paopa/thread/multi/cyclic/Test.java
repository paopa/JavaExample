package pers.paopa.thread.multi.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        try {
            CyclicBarrier cb = new CyclicBarrier(4);
            int i = 0;
            while (i < 5) {
                es.execute(new CyclicThreadExample(cb));
                Thread.sleep(500);
                i++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            es.shutdown();
        }
    }
}
