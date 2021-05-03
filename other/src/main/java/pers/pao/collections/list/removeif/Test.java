package pers.pao.collections.list.removeif;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>() {{
            this.add("a_not_null");
            this.add("a_pkey");
            this.add("index_a_xxx");
        }};
        objects.removeIf(x -> x.endsWith("_not_null") || x.endsWith("_pkey"));
        System.out.println(objects);
    }
}
