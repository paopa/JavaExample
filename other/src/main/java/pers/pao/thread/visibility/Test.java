package pers.pao.thread.visibility;

/**
 * 藉由 volatile key word 處理在 multi thread 時
 * 共用變數產生的可視性問題。
 *
 * 以下面為例
 * 每當啟動一個 thread 會將有自己的本地變數會有共享變數
 * 而在讀寫上就可能造成不一致的落差，使用 key word volatile
 * 則會強制從 主記憶體中取出變數 確保在不同 thread 看到的值
 * 是一致的。
 */
public class Test {

    volatile static Integer num = 0;

    public static void main(String[] args) {
        new Test().demo();
    }

    private void demo() {

        Thread readerThread = new Thread(() -> {
            int temp = 0;
            while (true) {
                if (temp != num) {
                    temp = num;
                    System.out.println("reader: value of num = " + num);
                }
            }
        });

        Thread writerThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                num++;
                System.out.println("writer: changed value to = " + num);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.exit(0);
        });

        readerThread.start();
        writerThread.start();
    }
}
