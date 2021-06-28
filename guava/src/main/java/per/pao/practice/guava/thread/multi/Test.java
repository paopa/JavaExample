package per.pao.practice.guava.thread.multi;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class Test
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(executor);
        try {
            ListenableFuture<String> task1 = service.submit(() -> {
                System.out.println("in hello task");
                Thread.sleep(1000);
                return "Hello";
            });
            ListenableFuture<String> task2 = service.submit(() -> {
                System.out.println("in world task");
                return "World";
            });
            System.out.println("main thread");
            String result = Futures.allAsList(task1, task2).get()
                    .stream().collect(Collectors.joining(" "));
            System.out.println(result);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            service.shutdown();
            executor.shutdown();
        }
    }
}
