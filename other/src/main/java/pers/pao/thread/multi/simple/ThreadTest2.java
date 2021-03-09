package pers.pao.thread.multi.simple;

/**
 * 就測試結果來看，輸出的值是無法預期的，可能原因為啟動 thread 的時間差或是其他因素，
 * 所以執行時間並不像是依照 code 中寫的順序執行。
 */
public class ThreadTest2 implements Runnable {

    private String message;

    public ThreadTest2(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000L);
            System.out.println("Thread message is:" + this.message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
