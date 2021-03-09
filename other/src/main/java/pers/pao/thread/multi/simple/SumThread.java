package pers.pao.thread.multi.simple;

public class SumThread implements Runnable {

    int sum;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i <= 100; i++) {
                sum += i;
            }
            notify();
        }
    }
}
