package pers.pao.thread.multi.exchanger.simple;

import java.util.concurrent.Exchanger;

public class ExchangerExample implements Runnable {

    private Exchanger exchanger;
    private String threadName;
    private String message;

    public ExchangerExample(Exchanger exchanger, String threadName, String message) {
        this.exchanger = exchanger;
        this.threadName = threadName;
        this.message = message;
    }


    @Override
    public void run() {
        try {
            System.out.println("Thread name: " + threadName + " Message: " + message);
            this.message = (String) exchanger.exchange(message);
            System.out.println("Thread name: " + threadName + " Message: " + message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
