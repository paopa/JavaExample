package per.pao.practice.guava.thread.base;

import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test
{
    public static void main(String[] args)
            throws Exception
    {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);
        try {
//            submit(service);
            submitAsync(service);
        }
        finally {
            service.shutdown();
            threadPool.shutdown();
        }
    }

    private static void submitAsync(ListeningExecutorService service)
            throws Exception
    {
        AsyncCallable<String> callable = Callables.asAsyncCallable(() -> {
            Thread.sleep(4000);
//            if (true) {
//                throw new Exception("asdf");
//            }
            return "output string";
        }, service);
        ListenableFuture<String> task = Futures.submitAsync(callable, service);
        Futures.addCallback(
                task,
                new FutureCallback<>()
                {
                    @Override
                    public void onSuccess(@Nullable String result)
                    {
                        System.out.println("on success " + result);
                    }

                    @Override
                    public void onFailure(Throwable t)
                    {
                        System.out.println("on failure");
                    }
                },
                service);
        System.out.println("main thread");
        task.get();
    }

    private static void submit(ListeningExecutorService service)
            throws Exception
    {
        ListenableFuture<String> task = service.submit(() -> {
            System.out.println("in task");
            Thread.sleep(4000);
            return "output string";
        });
        System.out.println("print first");
        String result = task.get();
        System.out.println(result);
    }
}
