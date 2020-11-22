package pers.paopa.assertj.simple;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class SoftAssertTest {
    @Test
    public void testSoftAssert() {
        int number1 = 5;
        int number2 = 10;
        int except = 15;

        int actual = number1 + number2;

        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(actual).isLessThan(10);
        assertions.assertThat(actual).isEqualTo(except);
        assertions.assertThat(actual).isEqualTo(11);
        assertions.assertAll();
    }
}
