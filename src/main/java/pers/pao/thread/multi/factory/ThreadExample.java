package pers.pao.thread.multi.factory;

public class ThreadExample implements Runnable {

    private String message;

    public ThreadExample(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        System.out.println(this.message);
    }
}
