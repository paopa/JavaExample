package pers.pao.collections.list.simple;

import java.util.ArrayList;
import java.util.List;

public class AddListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add(0,"123");
        list.forEach(System.out::println);
        list.remove(0);
        list.add(0,"4564564");
        list.forEach(System.out::println);
    }
}
