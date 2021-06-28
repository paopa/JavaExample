package per.pao.practice.guava.primitivetype.bytes;

import com.google.common.primitives.Bytes;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        final byte[] bytes = {1, 2, 3, 4, 5, 5, 7, 9, 9};
        convertToObjectList(bytes);
        convertToObjectArray(Bytes.asList(bytes));
        containsTest(bytes);
        indexOfTest(bytes);
        lastIndexOfTest(bytes);
    }

    private static void lastIndexOfTest(byte[] bytes) {
        byte data = 5;
        System.out.println("Last index of " + data + " : " + Bytes.lastIndexOf(bytes, data));
    }

    private static void indexOfTest(byte[] bytes) {
        byte data = 5;
        System.out.println("Index of " + data + " : " + Bytes.indexOf(bytes, data));
        data = 6; // not exist will return -1
        System.out.println("Index of " + data + " : " + Bytes.indexOf(bytes, data));
    }

    private static void containsTest(byte[] bytes) {
        byte data = 5;
        System.out.println(data + " is in list ? " + Bytes.contains(bytes, data));
        data = 6;
        System.out.println(data + " is in list ? " + Bytes.contains(bytes, data));
    }

    private static void convertToObjectArray(List<Byte> bytes) {
        byte[] array = Bytes.toArray(bytes);
        System.out.print("[");
        for (byte b : array) {
            System.out.print(b + " ");
        }
        System.out.println("]");
    }

    private static void convertToObjectList(byte[] bytes) {
        List<Byte> list = Bytes.asList(bytes);
        System.out.println(list.toString());
    }
}
