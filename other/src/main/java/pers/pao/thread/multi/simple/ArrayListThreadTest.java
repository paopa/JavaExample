package pers.pao.thread.multi.simple;

import java.util.List;

public class ArrayListThreadTest implements Runnable {

    private List<String> list;

    public ArrayListThreadTest(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                this.list.add("a" + i);
                System.out.println(String.join(",", list));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
