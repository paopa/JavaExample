package pers.paopa.array.lrucache;

import java.util.*;

public class LruTest {
    public static void main(String[] args) {
        List<String> lruList = new ArrayList<>();
        Map<String, Long> lruCountMap = new HashMap<>();
        String[] data = createTestData();
        inputInListAndMap(data, lruList, lruCountMap);
        System.out.println("lruList: " + lruList);
        System.out.println("lruCountMap: " + lruCountMap);
        List<LruObject> lruObjectList = inputInObjectList(lruCountMap);
        Collections.sort(lruObjectList, LruObject.lruObjectComparator);
        lruObjectList.forEach(lru ->
                System.out.println(lru.name + " = " + lru.count));
    }

    private static String[] createTestData() {
        return new String[]{"a", "b", "d", "c", "a", "d", "a", "d","d", "a", "d", "b", "c", "c", "c", "c", "b", "d"};
    }

    private static List<LruObject> inputInObjectList(Map<String, Long> lruCountMap) {
        List<LruObject> lruObjectList = new ArrayList<>();
        for (String value : lruCountMap.keySet()) {
            LruObject lru = new LruObject();
            lru.name = value;
            lru.count = lruCountMap.get(value);
            lruObjectList.add(lru);
        }
        return lruObjectList;
    }

    private static void inputInListAndMap(String[] data, List<String> lruList, Map<String, Long> lruCountMap) {
        for (String value : data) {
            lruCountMap.putIfAbsent(value, 0L);
            lruList.remove(value);
            if (lruList.size() > 3) {

                lruList.remove(lruList.size() - 1);
            } else {
                lruCountMap.put(value, lruCountMap.get(value) + 1L);
                lruList.add(0, value);
            }
        }
    }
    static class LruObject implements Comparable<LruObject> {

        private String name;
        private Long count;

        @Override
        public int compareTo(LruObject o) {
            return (int) (this.count - o.count);
        }

        public static Comparator<LruObject> lruObjectComparator = new Comparator<LruObject>() {
            @Override
            public int compare(LruObject o1, LruObject o2) {
                return o2.compareTo(o1);
            }
        };
    }


}