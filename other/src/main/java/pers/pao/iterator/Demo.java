package pers.pao.iterator;

import java.util.Iterator;
import java.util.List;

public class Demo
{
    public static void main(String[] args)
    {
        List<Integer> list = List.of(1, 2, 3);
        for (Integer num : list) {
            System.out.println(list.iterator().hasNext() + " || " + num);
        }
        System.out.println(list.iterator().hasNext());

        System.out.println("---");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.println(iterator.hasNext() + " || " + num);
        }
    }
}
