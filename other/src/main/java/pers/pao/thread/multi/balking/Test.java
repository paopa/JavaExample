package pers.pao.thread.multi.balking;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        PrintString p = new PrintString();

        ScheduledExecutorService sec = Executors.newScheduledThreadPool(2);
        sec.scheduleAtFixedRate(new RunningExampleThread(p), 2, 2, TimeUnit.SECONDS);
        sec.scheduleAtFixedRate(new RunningExampleThread(p), 2, 2, TimeUnit.SECONDS);
    }
}

class PrintString {
    private boolean initFlag = false;

    public synchronized void running(String message) {
        if (!initFlag) {
            System.out.println("init " + message);
            initFlag = true;
        }
        System.out.println("running " + message);
    }
}

class RunningExampleThread implements Runnable {

    private PrintString printString;

    public RunningExampleThread(PrintString printString) {
        this.printString = printString;
    }

    @Override
    public void run() {
        String currentThread = Thread.currentThread().getName();
        this.printString.running(currentThread);
    }
}