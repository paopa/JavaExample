package pers.paopa.thread.multi.single.threaded.execution;

import lombok.SneakyThrows;

/**
 * 由於 Data object 為共用變數，所以有機會在 concurrency 情況下有不同的值
 * 將 Data class 修改成 immutable 是一種解法
 * 另一種則是在 setValue 加上 keyword synchronized
 * 只是在 synchronized 的情況下是會影響效能的
 */
public class Test {

    private static final String PREFIX = "value_";

    public static void main(String[] args) {
        Data data = new Data();
        for (int i = 0; i <= 1000; i++) {
            Thread thead = new Thread(new ThreadExample(data, PREFIX + i, PREFIX + i));
            thead.start();
        }
    }
}

class ThreadExample implements Runnable {

    private Data data;
    private String value1;
    private String value2;

    public ThreadExample(Data data, String value1, String value2) {
        this.data = data;
        this.value1 = value1;
        this.value2 = value2;
    }

    @SneakyThrows
    @Override
    public void run() {
        while (true) {
            Thread.sleep(500L);
            this.data.setValue(this.value1, this.value2);
        }
    }
}

class Data {
    private String value1 = "";
    private String value2 = "";

    public void setValue(String value1, String value2) {
        this.value1 = value1;
        this.value2 = value2;
        System.out.println(this.value1 + " " + this.value2 + " " + isValueEquals());
    }

//    private boolean isValueEquals() {
//        return this.value1.equals(this.value2);
//    }

    private synchronized boolean isValueEquals() {
        return this.value1.equals(this.value2);
    }
}
