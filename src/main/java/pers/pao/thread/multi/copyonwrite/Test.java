package pers.pao.thread.multi.copyonwrite;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test {

    public static void main(String[] args) throws Exception {
        testCopyOnWriteArrayList();
    }

    private static void testCopyOnWriteArrayList() throws Exception {
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.addAll(List.of("a1", "a2", "a3", "a4", "a5"));
        Thread thread = new Thread(new ThreadExample(list));
        thread.start();

        list.forEach(element -> {
            try {
                Thread.sleep(10);
                System.out.println(element);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

}
