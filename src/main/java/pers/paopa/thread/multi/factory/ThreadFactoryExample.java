package pers.paopa.thread.multi.factory;

import java.util.concurrent.ThreadFactory;

public class ThreadFactoryExample implements ThreadFactory {

    private int count = 0;

    @Override
    public Thread newThread(Runnable r) {
        count++;
        return new Thread(r);
    }

    public int getCount() {
        return count;
    }
}
