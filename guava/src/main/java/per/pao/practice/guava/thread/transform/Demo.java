package per.pao.practice.guava.thread.transform;

import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class Demo
{
    public static void main(String[] args)
            throws ExecutionException, InterruptedException
    {
        Executor executor = MoreExecutors.directExecutor();
        ListenableFuture<String> future = Futures.submit(() -> "xxxx", executor);
        ListenableFuture<Object> transform = Futures.transform(
                future,
                x -> x + "--suffix",
                executor);
        System.out.println(transform.get());
    }
}
