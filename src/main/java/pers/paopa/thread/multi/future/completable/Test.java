package pers.paopa.thread.multi.future.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("hello");
                Thread.sleep(1000);
                System.out.println("world");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.get();
        System.out.println("end");
    }
}
