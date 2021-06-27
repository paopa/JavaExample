package per.pao.practice.specified.conversion;

import lombok.Data;

public class UserBody
{
    @Data
    public static class ImperialValuesDto
    {
        private final int inch;
        private final int pound;
    }

    @Data
    public static class Values
    {
        private final double kilogram;
        private final double centimeter;
    }
}
