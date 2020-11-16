package pers.paopa.thread.visibility;

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
