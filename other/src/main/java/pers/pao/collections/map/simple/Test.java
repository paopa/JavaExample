package pers.pao.collections.map.simple;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap put method is not synchronized
 * Hashtable put method is synchronized
 * ConcurrentHashMap put 條件下 synchronized 效能比 hashtable 好
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Object> map = new HashMap<>();
        map.put(1,"asdf");
        Hashtable<Integer, Object> table = new Hashtable<>();
        table.put(1,"asdf");
        ConcurrentHashMap<Integer, Object> cMap = new ConcurrentHashMap<>();
        cMap.put(1,"asdf");
    }
}
