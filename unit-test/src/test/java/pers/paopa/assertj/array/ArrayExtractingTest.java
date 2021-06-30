package pers.paopa.assertj.array;

import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ArrayExtractingTest
{
    @Test
    public void testObjectArray()
    {
        List<Object> list = List.of(1, "12");
        System.out.println("break");
        assertThat(list)
                .extracting("value")
                .contains(1, "12".getBytes(StandardCharsets.UTF_8));
    }
}
