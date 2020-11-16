package pers.paopa.thread.multi.future;

public class Callable implements java.util.concurrent.Callable<String> {

    private String message;
    private long sleepTimeMillis;

    public Callable(String message, long sleepTimeMillis) {
        this.message = message;
        this.sleepTimeMillis = sleepTimeMillis;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(sleepTimeMillis);
        return this.message;
    }
}
