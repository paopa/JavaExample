package pers.paopa.array;

import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {

    static final Queue<Long> queue = new LinkedList<>();

    public static void main(String[] args) {
//        addDemo();
        offerDemo();
    }

    private static void offerDemo() {
        List<Long> list = generateExampleList(1000);
        list.forEach(queue::offer);
        System.out.println(queue);
    }

    private static void addDemo() {
        List<Long> list = generateExampleList(1000);
        list.forEach(queue::add);
        System.out.println(queue);
    }

    private static List<Long> generateExampleList(long size) {
        List<Long> list = new ArrayList<>();
        for (long i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }
}
