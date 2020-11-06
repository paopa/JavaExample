package pers.paopa.array.simple;

import java.util.List;

public class ContainsTest {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        List<Long> selectColumns = List.of(1L,2L,3L);
        List<Long> transcriptColumns = List.of(1L,2L,4L);
        System.out.println(selectColumns.containsAll(transcriptColumns));
    }
}
