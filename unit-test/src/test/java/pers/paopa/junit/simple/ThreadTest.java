package pers.paopa.junit.simple;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ThreadTest {

    @Test
    public void testWithAsyncThread() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("a");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        System.out.println("end");
    }

    @Test
    public void testWithCompletableThread() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("a");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        future.get();
        System.out.println("end");
    }

    @Test
    public void testWithFutureTask() throws ExecutionException, InterruptedException {
        FutureTask<Void> task = new FutureTask<>(() -> {
            Thread.sleep(1000);
            System.out.println("a");
            return null;
        });
        Executors.newSingleThreadExecutor().execute(task);
        task.get();
        System.out.println("end");
    }
}
