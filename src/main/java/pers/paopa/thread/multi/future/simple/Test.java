package pers.paopa.thread.multi.future.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception {
        demo();
    }

    private static void demo() throws Exception {
        Callable callable1 = new Callable("message-1", 2000);
        Callable callable2 = new Callable("message-2", 1000);

        FutureTask<String> task1 = new FutureTask<>(callable1);
        FutureTask<String> task2 = new FutureTask<>(callable2);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(task1);
        executor.execute(task1);
        executor.execute(task2);

        System.out.println(task1.get());
        System.out.println(task2.get());
        System.exit(0);
    }
}
