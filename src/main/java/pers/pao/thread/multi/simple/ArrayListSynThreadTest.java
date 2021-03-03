package pers.pao.thread.multi.simple;

import java.util.List;

public class ArrayListSynThreadTest implements Runnable {

    private List<String> list;

    public ArrayListSynThreadTest(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                synchronized (list) {
                    this.list.add("a" + i);
                    System.out.println(String.join(",", list));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
