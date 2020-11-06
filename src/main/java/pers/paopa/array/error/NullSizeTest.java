package pers.paopa.array.error;

import java.util.List;

public class NullSizeTest {
    public static void main(String[] args) {
        List<String> test = null;
        if (test.size() > 0) {
            System.out.println("pass");
            return;
        }
        System.out.println("failed");
    }
}
