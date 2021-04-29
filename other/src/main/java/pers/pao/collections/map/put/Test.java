package pers.pao.collections.map.put;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>() {{
            this.put("1", "1");
            this.put("1", "1-1");
        }};

        System.out.println(hashMap);
    }
}
