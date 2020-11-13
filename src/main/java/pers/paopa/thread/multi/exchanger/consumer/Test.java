package pers.paopa.thread.multi.exchanger.consumer;

import pers.paopa.thread.multi.exchanger.producer.ProducerThreadExample;

import java.util.concurrent.Exchanger;

public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        Exchanger exchanger = new Exchanger();
        Thread producer = new Thread(new ProducerThreadExample(exchanger));
        producer.start();
        Thread consumer = new Thread(new ConsumerThreadExample(exchanger));
        consumer.start();
    }
}
