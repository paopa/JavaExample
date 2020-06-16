package pers.paopa.array;

import java.util.ArrayList;
import java.util.List;

public class ListAddNullTest {
    public static void main(String[] args) {
        List<String> currentRecord = new ArrayList<>();
        currentRecord.add(null);
        currentRecord.add(null);
        currentRecord.add("1");
        currentRecord.add(null);
        System.out.println(currentRecord);
    }
}
