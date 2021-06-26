package pers.paopa.assertj.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AssertJTest {

    @Test
    public void test() {
        assertThatThrownBy(AssertJTest::throwException)
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Err....");
    }

    private static void throwException() {
        throw new RuntimeException("Err....");
    }
}
