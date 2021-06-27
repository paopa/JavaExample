package per.pao.practice.lombok;

import lombok.Data;

public class Car
{
    @Data
    public static class Entity
    {
        private final int id;
        private final String name;
    }

    @Data
    public static class Dto
    {
        private final int id;
        private final String name;
    }
}
