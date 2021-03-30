package pers.pao.collections.list.simple;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ArrayList: array 結構 取快
 * LinkedList: node 結構 取需要遍歷 not singly linked
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.get(0);
        LinkedList<String> list2 = new LinkedList<>();
        list2.add("ddd");
        list2.get(0);
    }
}
