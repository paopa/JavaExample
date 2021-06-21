package per.pao.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Model
{
    @Data
    public static class Request
    {
        private final int intValue;
        private String stringValue;
    }

    @AllArgsConstructor
    public static class Response
    {
        private final int intValue;
    }
}
