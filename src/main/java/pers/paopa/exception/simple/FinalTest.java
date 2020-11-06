package pers.paopa.exception.simple;

import java.io.IOException;

public class FinalTest {
    public static void main(String[] args) throws IOException {
        try {
            int i = 1 / 0;
            Double.parseDouble("123%");
        } finally {
            System.out.println("final");
        }
        System.out.println("end");
    }
}
