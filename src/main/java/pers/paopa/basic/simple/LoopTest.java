package pers.paopa.basic.simple;

public class LoopTest {
    public static void main(String[] args) {
        exec();
    }

    private static void exec() {
        for (int i = 0; i < 300; i++) {
            System.out.print(i);
            if (i < 299) System.out.print(",");
            continue;
        }
    }
}
