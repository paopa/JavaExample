package pers.paopa.junit.equal;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * note: 目前還沒想到測試情境去進行比較
 */
public class EqualTest {

    @DisplayName("test isEqualTo")
    @Test
    public void testIsEqualTo() {
        Long a = 1L;
        Long b = 1L;
        Assertions.assertThat(a).isEqualTo(b);
    }

    @DisplayName("test isEqualByComparingTo")
    @Test
    public void testIsEqualByComparingTo() {
        Long a = 1L;
        Long b = 1L;
        Assertions.assertThat(a).isEqualByComparingTo(b);
    }
}
