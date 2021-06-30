package per.pao.practice.guava.thread.chains;

import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Executors;

public class Test
{
    public static void main(String[] args)
    {
        ListeningExecutorService service = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        try {

            ListenableFuture<String> task = Futures.submit(() -> "xxxx", service);

            AsyncFunction<String, String> function1 = new AsyncFunction<>()
            {
                @Override
                public ListenableFuture<String> apply(@Nullable String input)
                        throws Exception
                {
                    return Futures.submit(() -> input + "-function1", service);
                }
            };

//            AsyncFunction<String, String> function2 = input -> Futures.submit(() -> input + "-function2", service);

            ListenableFuture<String> result = Futures.transformAsync(task, function1, service);
            System.out.println("maint thread");
            System.out.println(result.get());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            service.shutdown();
        }
    }
}
