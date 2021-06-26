package pers.paopa.assertj.simple;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void testEqualTo() {
        int input = 1;
        int output = 1;
        assertThat(input).isEqualTo(output);
    }

    @Test
    public void testCase() {
        // 1.Arrange
        int number1 = 5;
        int number2 = 10;
        int expected = 15;

        // 2.Act
        int actual = number1 + number2;

        // 3.Assert
        assertThat(actual).isEqualTo(expected);
    }

}
