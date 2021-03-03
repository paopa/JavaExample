package pers.pao.array.simple;

import java.util.ArrayList;
import java.util.List;

public class ArrayToList {
    public static void main(String[] args) {
        List<List<String>> rowDataList = new ArrayList<>();
        List<String> rowList = new ArrayList<>();
        String[] xx = {null, "q", "e", "r"};
        for (String value : xx) {
            if (value == null) {
                value = "";
            }
            rowList.add(value);
        }
        if (rowDataList.size() < 6) {
            rowDataList.add(rowList);
        }
        System.out.println(rowDataList);
    }
}
