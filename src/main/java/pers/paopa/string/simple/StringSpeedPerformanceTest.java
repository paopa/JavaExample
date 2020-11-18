package pers.paopa.string.simple;

public class StringSpeedPerformanceTest {

    static int size = 1000_000;

    public static void main(String[] args) {
        demoString();
        demoStringBuffer();
        demoStringBuilder();
        demoStringFormat();
    }

    private static void demoString() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String x = "1" + "a" + "b";
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    private static void demoStringBuffer() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String x = new StringBuffer().append("1").append("a").append("b").toString();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    private static void demoStringBuilder() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String x = new StringBuilder().append("1").append("a").append("b").toString();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }

    private static void demoStringFormat() {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            String x = String.format("%s%s%s", "1", "a", "b");
        }
        long end = System.currentTimeMillis();
        System.out.println("cost:" + (end - start));
    }
}
