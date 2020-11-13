package pers.paopa.thread.multi.exchanger.producer;

import java.util.concurrent.Exchanger;

public class ProducerThreadExample implements Runnable {

    private Exchanger<StringBuffer> exchanger;
    private StringBuffer sb = new StringBuffer();

    public ProducerThreadExample(Exchanger<StringBuffer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sb.append("message-").append(i);
                sb = this.exchanger.exchange(sb);
                System.out.println("Producer " + sb.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
