package pers.pao.map.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class mergeMap {
    public static void main(String[] args) {
        Map<String, Long> map = generate();
        System.out.println(map);
        Map<String, Long> map2 = generate();
        System.out.println(map2);
        List<Map<String, Long>> list = new ArrayList<>();
        list.add(map);
        list.add(map2);
        Map<String, Long> mergeMap = merge(list);
        System.out.println(mergeMap);
    }

    private static Map<String, Long> merge(List<Map<String, Long>> list) {
        Map<String, Long> map = new TreeMap<>();
        list.forEach(element -> element.forEach((k, v) -> {
            if (map.containsKey(k)) {
                map.put(k, map.get(k) + v);
                return;
            }
            map.put(k, v);
        }));
        return map;
    }

    private static Map<String, Long> generate() {
        TreeMap<String, Long> map = new TreeMap<>();
        map.put("a", 1L);
        map.put("b", 1L);
        map.put("c", 1L);
        map.put("d", 1L);
        return map;
    }
}
