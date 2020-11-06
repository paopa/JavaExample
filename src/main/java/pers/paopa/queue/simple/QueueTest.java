package pers.paopa.queue.simple;

import org.apache.commons.collections.ArrayStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QueueTest {

    static final Queue<Long> queue = new LinkedList<>();

    public static void main(String[] args) {
//        addDemo();
//        offerDemo();
//        mergeDemo();
        deleteDemo();
    }

    private static void deleteDemo() {
        Queue<Long> queue1 = new LinkedList<>(generateExampleList(5));
        System.out.println(queue1);
        queue1.removeAll(List.of(1L, 2L));
        System.out.println(queue1);
    }

    private static void mergeDemo() {
        Queue<Long> queue1 = new LinkedList<>(generateExampleList(5));
        Queue<Long> queue2 = new LinkedList<>(generateExampleList(5));
        queue1.addAll(queue2);
        System.out.print(queue1);
    }


    private static void offerDemo() {
        List<Long> list = generateExampleList(5);
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
