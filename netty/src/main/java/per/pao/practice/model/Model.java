package per.pao.practice.model;

import lombok.Data;

public class Model
{
    @Data
    public static class Request
    {
        private final int intValue;
        private String stringValue;
    }

    @Data
    public static class Response
    {
        private final int intValue;
    }
}
