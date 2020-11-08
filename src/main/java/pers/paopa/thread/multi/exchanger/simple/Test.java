package pers.paopa.thread.multi.exchanger.simple;

import java.util.concurrent.Exchanger;

public class Test {
    public static void main(String[] args) {
        testExchanger();
    }

    private static void testExchanger() {
        Exchanger exchanger = new Exchanger();

        ExchangerExample e1 = new ExchangerExample(exchanger,"thread1","message1");
        Thread thread1 = new Thread(e1);
        thread1.start();

        ExchangerExample e2 = new ExchangerExample(exchanger,"thread2","message2");
        Thread thread2 = new Thread(e2);
        thread2.start();

        ExchangerExample e3 = new ExchangerExample(exchanger,"thread3","message3");
        Thread thread3 = new Thread(e3);
        thread3.start();

        ExchangerExample e4 = new ExchangerExample(exchanger,"thread4","message4");
        Thread thread4 = new Thread(e4);
        thread4.start();
    }
}
