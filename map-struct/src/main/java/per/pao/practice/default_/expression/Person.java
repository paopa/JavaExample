package per.pao.practice.default_.expression;

import lombok.Data;

public class Person
{
    @Data
    public static class Entity
    {
        private final String uuid;
        private final String name;
    }

    @Data
    public static class Dto
    {
        private final String uuid;
        private final String name;
    }
}
