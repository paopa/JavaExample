package pers.paopa.assertj.simple;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertJTest {

    @Test
    public void testCase() {
        int input = 1;
        int output = 1;
        assertThat(input).isEqualTo(output);
    }
    
}
