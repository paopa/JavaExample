package pers.pao.thread.multi.timer;

import java.util.Timer;
import java.util.TimerTask;

public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        TimerTask task1 = new TimerTaskExample(start,true);
//        TimerTask task2 = new TimerTaskExample(start,false);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task1, 1000, 2000);
//        timer.scheduleAtFixedRate(task2, 1000, 2000);
    }
}
