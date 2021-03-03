package pers.pao.thread.multi.exchanger.consumer;

import java.util.concurrent.Exchanger;

public class ConsumerThreadExample implements Runnable {

    private Exchanger<StringBuffer> exchanger;

    public ConsumerThreadExample(Exchanger<StringBuffer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                StringBuffer sb = new StringBuffer();
                sb = this.exchanger.exchange(sb);
                System.out.println("Consumer " + sb.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
