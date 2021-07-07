package pers.pao.thread.multi.future.completable.apply.and.complete;

import java.util.concurrent.CompletableFuture;

import static java.util.Objects.isNull;

public class Demo
{
    public static void main(String[] args)
    {
        CompletableFuture.supplyAsync(() -> "test")
                .thenApply(text -> {
//                    if (true) {
//                        throw new NullPointerException("asdf");
//                    }
                    return text + "-a";
                })
                .whenComplete((x, throwable) -> {
                    if (!isNull(throwable)) {
                        System.out.println("asdfffff");
                        new Exception(throwable).printStackTrace();
                        return;
                    }
                    System.out.println(x);
                });
    }
}
