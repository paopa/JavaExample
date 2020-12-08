package pers.paopa.thread.multi.thread.per.message;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(5);
        Host host = new Host();
        for (int i = 0; i <= 5; i++) {
            host.request(es, "client-" + i, "message-" + i);
        }
        es.shutdown();
    }
}

class Host {

    public void request(ExecutorService es, String clientId, String message) {
        es.execute(new Request(clientId, message));
    }

    class Request implements Runnable {
        private String clientId;
        private String message;

        public Request(String clientId, String message) {
            this.clientId = clientId;
            this.message = message;
        }

        @SneakyThrows
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println("Thread: " + threadName +
                    " Client id: " + this.clientId + " message: " + this.message);
        }
    }
}
