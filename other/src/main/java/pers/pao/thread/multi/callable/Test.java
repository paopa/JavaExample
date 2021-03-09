package pers.pao.thread.multi.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test {
    public static void main(String[] args) throws Exception {
        FutureTask<Integer> f1 = new FutureTask<>(new Sum(10));
        FutureTask<Integer> f2 = new FutureTask<>(new Sum(100));
        FutureTask<Integer> f3 = new FutureTask<>(new Sum(1000));
        new Thread(f1).start();
        new Thread(f2).start();
        new Thread(f3).start();
        System.out.println("main sum: " + (f1.get() + f2.get() + f3.get()));
    }
}

class Sum implements Callable<Integer> {

    private int count;

    Sum(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= this.count; i++) {
            sum += i;
        }
        return sum;
    }
}


