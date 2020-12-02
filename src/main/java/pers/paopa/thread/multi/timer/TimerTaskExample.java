package pers.paopa.thread.multi.timer;

import lombok.SneakyThrows;

import java.util.TimerTask;

public class TimerTaskExample extends TimerTask {

    private long start;
    private boolean type;

    public TimerTaskExample(long start, boolean type) {
        this.start = start;
        this.type = type;
    }

    @SneakyThrows
    @Override
    public void run() {
        if (type) {
            long runningTime = System.currentTimeMillis() - this.start;
            System.out.println(runningTime);
            Thread.sleep(4000);
        } else {
            throw new RuntimeException();
        }
    }
}
