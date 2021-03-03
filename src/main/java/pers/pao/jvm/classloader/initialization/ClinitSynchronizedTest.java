package pers.pao.jvm.classloader.initialization;

/**
 * 測試 clinit 是否有進行鎖定
 */
public class ClinitSynchronizedTest {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName() + " start");
            new A();
            System.out.println(Thread.currentThread().getName() + " end");
        };

        Thread thread1 = new Thread(runnable, "thread 1");
        Thread thread2 = new Thread(runnable, "thread 2");

        thread1.start();
        thread2.start();
    }

}

class A {
    static {
        if (true) {
            System.out.println(Thread.currentThread().getName() + " initial " + A.class);
            while (true) {

            }
        }
    }
}

