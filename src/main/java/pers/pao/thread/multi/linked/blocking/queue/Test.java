package pers.pao.thread.multi.linked.blocking.queue;

import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) throws Exception {
//        testAddQueue();
//        testPutQueue();
//        testOfferQueue();
//        testPollQueue();
//        testTakeQueue();
//        testElementQueue();
        testPeekQueue();
    }

    /**
     * 使用 peek 功能與 element method 很像
     * 當 queue 內沒有值時回傳 null
     */
    private static void testPeekQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("aaa");
        String element1 = queue.peek();
        System.out.println(element1);
        String element2 = queue.peek();
        System.out.println(element2);
        queue.poll();
        String element3 = queue.peek();
        System.out.println(element3);
    }

    /**
     * 使用 element 會取出值，但不會將值從 queue 中移除
     * 當 queue 中沒有值則會 throw NoSuchElementException
     */
    private static void testElementQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("aaa");
        String element1 = queue.element();
        System.out.println(element1);
        String element2 = queue.element();
        System.out.println(element2);
        queue.poll();
        String element3 = queue.element();
        System.out.println(element3);
    }

    /**
     * 使用 take 當 queue 內沒有 element 則會 阻塞
     *
     * @throws InterruptedException
     */
    private static void testTakeQueue() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("aaa");
        String element1 = queue.take();
        System.out.println(element1);
        String element2 = queue.take();
        System.out.println(element2);
    }

    /**
     * 使用 poll 當 queue 內沒有 element 會回傳 null
     */
    private static void testPollQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("aaa");
        String element1 = queue.poll();
        System.out.println(element1);
        String element2 = queue.poll();
        System.out.println(element2);
    }

    /**
     * 當 queue 已滿則會回傳 false
     */
    private static void testOfferQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        boolean a = queue.offer("message1");
        System.out.println(a);
        boolean b = queue.offer("message2");
        System.out.println(b);
        boolean c = queue.offer("message3");
        System.out.println(c);
    }

    /**
     * 當達到 queue 能放入的上限就阻塞直到有空間
     *
     * @throws InterruptedException
     */
    private static void testPutQueue() throws InterruptedException {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        queue.put("message1");
        queue.put("message2");
        queue.put("message3");
    }

    /**
     * 超出設定的 queue 上限會 throw java.lang.IllegalStateException: Queue full
     */
    private static void testAddQueue() {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>(2);
        boolean a = queue.add("message1");
        System.out.println(a);
        boolean b = queue.add("message2");
        System.out.println(b);
        boolean c = queue.add("message3");
        System.out.println(c);
    }
}
