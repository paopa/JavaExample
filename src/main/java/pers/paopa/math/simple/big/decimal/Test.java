package pers.paopa.math.simple.big.decimal;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        System.out.println(new BigDecimal("8.075", new MathContext(3, RoundingMode.HALF_EVEN)));
    }
}
