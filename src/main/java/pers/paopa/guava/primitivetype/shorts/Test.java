package pers.paopa.guava.primitivetype.shorts;

import com.google.common.primitives.Bytes;
import com.google.common.primitives.Shorts;

public class Test {
    public static void main(String[] args) {
        short[] shorts = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        maxAndMin(shorts);
        convertToByteArray(shorts);
    }

    private static void convertToByteArray(short[] shorts) {
        short data = 2400;
        byte[] bytes = Shorts.toByteArray(data);
        System.out.println(Bytes.asList(bytes));
    }

    private static void maxAndMin(short[] shorts) {
        System.out.println("Min: " + Shorts.min(shorts));
        System.out.println("Max: " + Shorts.max(shorts));
    }
}
