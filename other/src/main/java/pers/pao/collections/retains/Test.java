package pers.pao.collections.retains;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> list1 = new ArrayList<Integer>() {{
            add(1);
            add(3);
            add(5);
        }};

        List<Integer> list2 = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };

        list.clear();
        list.addAll(list1);
        System.out.println("去重複交集前1：" + list1);
        System.out.println("去重複交集前2：" + list2);
        list.retainAll(list2);
        System.out.println("list1與list2的交集是：" + list);

    }
}
