package pers.paopa.thread.multi.producer.consumer;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 需要注意的是，當 Producer 生產資料的數度大於 Consumer 消費資料的數度時
 * 就有可能將記憶體塞滿，造成 OOM 的問題，這也就是為什麼會在 put method 上
 * 判斷 queue 大於 10 就進入 wait 的原因。
 */
public class Test {
    public static void main(String[] args) {
        Channel channel = new Channel();
        Thread producer1 = new Thread(new Producer(channel));
        Thread producer2 = new Thread(new Producer(channel));
        Thread consumer = new Thread(new Consumer(channel));
        producer1.start();
        producer2.start();
        consumer.start();
    }
}

class Consumer implements Runnable {

    private Channel channel;

    public Consumer(Channel channel) {
        this.channel = channel;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String message = this.channel.take();
            System.out.println("Consumer: " + message);
        }
    }
}

class Producer implements Runnable {

    private Channel channel;
    private static int id = 0;

    public Producer(Channel channel) {
        this.channel = channel;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000L);
            String message = "message-" + nextId();
            System.out.println("Producer: " + message);
            this.channel.put(message);
        }
    }

    private synchronized static int nextId() {
        return id++;
    }
}

class Channel {
    private final Queue<String> queue = new LinkedList<>();

    public synchronized void put(String message) throws InterruptedException {
        while (queue.size() >= 10) {
            wait();
        }
        queue.offer(message);
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (queue.peek() == null) {
            wait();
        }
        notifyAll();
        return queue.remove();
    }
}
