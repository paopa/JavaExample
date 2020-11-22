package pers.paopa.stream.parallel;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ParallelTest {

    private static List<String> list;

    @BeforeAll
    static void init() {
        list = List.of("123", "1234", "abc", "xd2ww", "brqdadsf", "abcd", "asdf", "zxcvadf", "rqewgw", "acvwreq", "ad", "gqe");
    }

    @Test
    public void test() {
        list.parallelStream().filter(x -> x.length() > 3).forEach(System.out::println);

    }

    @Test
    public void streamTest() {
        list.stream().filter(x -> x.length() > 3).forEach(System.out::println);
    }
}
