package pers.paopa.thread.multi.semaphore;

import java.util.List;

public class ThreadExample2 implements Runnable {

    private List<String> list;

    public ThreadExample2(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                list.add("b" + i);
                Thread.sleep(9);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
