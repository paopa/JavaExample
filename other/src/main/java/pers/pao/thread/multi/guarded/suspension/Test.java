package pers.pao.thread.multi.guarded.suspension;

import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) {
        GuardedObject guarded = new GuardedObject();
        Thread putThread = new Thread(new PutThreadExample(guarded));
        Thread getThread = new Thread(new GetThreadExample(guarded));
        putThread.start();
        getThread.start();
    }
}

class GetThreadExample implements Runnable {

    private GuardedObject guarded;

    public GetThreadExample(GuardedObject guarded) {
        this.guarded = guarded;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            String message = this.guarded.getQueue();
            System.out.println(message);
        }
    }
}


class PutThreadExample implements Runnable {

    private GuardedObject guarded;

    public PutThreadExample(GuardedObject guarded) {
        this.guarded = guarded;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            String str = "message" + i;
            this.guarded.putQueue(str);
            Thread.sleep(1000L);
        }
    }
}

class GuardedObject {
    private final Queue<String> queue = new LinkedList<>();

    public synchronized String getQueue() throws InterruptedException {
        while (queue.peek() == null) {
            wait();
        }
        return queue.remove();
    }

    public synchronized void putQueue(String message) {
        queue.offer(message);
        notify();
    }
}
