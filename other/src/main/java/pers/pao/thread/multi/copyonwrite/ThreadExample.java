package pers.pao.thread.multi.copyonwrite;

import java.util.List;

public class ThreadExample implements Runnable {

    private List<String> list;

    public ThreadExample(List<String> list) {
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
