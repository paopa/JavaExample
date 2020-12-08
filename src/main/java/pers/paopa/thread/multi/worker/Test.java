package pers.paopa.thread.multi.worker;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

/**
 * client 送出的 request 會隨機給 worker 消費掉
 */
public class Test {
    public static void main(String[] args) {
        Channel channel = new Channel(2);
        channel.startWorkerThread();

        Thread client1 = new Thread(new Client("client1", channel));
        Thread client2 = new Thread(new Client("client2", channel));
        client1.start();
        client2.start();
    }
}

class Channel {

    private int workerNum;
    private final Queue<Request> queue = new LinkedList<>();

    public Channel(int workerNum) {
        this.workerNum = workerNum;
    }

    public void startWorkerThread() {
        for (int i = 0; i < workerNum; i++) {
            Thread thread = new Thread(new Worker(this));
            thread.start();
        }
    }

    public synchronized void put(Request request) throws InterruptedException {
        while (queue.size() >= 10) {
            wait();
        }
        queue.offer(request);
        notifyAll();
    }

    public synchronized Request take() throws InterruptedException {
        while (this.queue.peek() == null) {
            wait();
        }
        notifyAll();
        return this.queue.remove();
    }

}

class Client implements Runnable {

    private String client;
    private Channel channel;

    public Client(String client, Channel channel) {
        this.channel = channel;
        this.client = client;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(1000);
            this.channel.put(new Request(client));
        }
    }
}

class Worker implements Runnable {

    private Channel channel;

    public Worker(Channel channel) {
        this.channel = channel;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Request request = this.channel.take();
            request.execute();
        }
    }
}

class Request {

    private String message;

    public Request(String message) {
        this.message = message;
    }

    public void execute() {
        String threadName = Thread.currentThread().getName();
        System.out.println("message: " + this.message + " Worker Thread is: " + threadName);
    }
}
