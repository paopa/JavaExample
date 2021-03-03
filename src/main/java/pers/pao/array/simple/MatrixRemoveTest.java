package pers.pao.array.simple;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class MatrixRemoveTest {

    public static void main(String[] args) {
        List<Long> columns = Arrays.asList(1L, 2L, 3L);
        List<Long> selectColumns = Arrays.asList(1L,3L);

        List<Long> indexes = columns.stream()
                .filter(selectColumns::contains)
                .map(id -> (long) columns.indexOf(id))
                .collect(toList());
        System.out.println(columns);
        System.out.println(indexes);
    }
}
