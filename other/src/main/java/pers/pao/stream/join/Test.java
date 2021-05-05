package pers.pao.stream.join;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        StringBuilder sql = new StringBuilder("select * from aa ");
        ArrayList<String> objects = new ArrayList<>();
        objects.add(null);
        objects.add(null);
        objects.add("");
        objects.add(" id == ? ");
        objects.add(" xx == ? ");
        objects.removeIf(x -> x == null || x.isEmpty());
        if (!objects.isEmpty()) {
            sql.append(objects.stream()
                    .collect(Collectors.joining(" and ", " where ", "")));
        }
        System.out.println(sql);
    }
}
