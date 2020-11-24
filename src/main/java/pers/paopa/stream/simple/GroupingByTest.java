package pers.paopa.stream.simple;

import lombok.Data;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class GroupingByTest {
    public static void main(String[] args) {
        List<Mock> mocks = new GroupingByTest().prepare();
        var list = mocks.stream().
                collect(groupingBy(Mock::getName, toList()))
                .entrySet();
        System.out.println(list);
    }

    private List<Mock> prepare() {
        return List.of(new Mock("a", 12), new Mock("b", 10));
    }

}

@Data
class Mock {

    private final String name;
    private final int test;
}
