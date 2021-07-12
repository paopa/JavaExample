package per.pao.practice.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Mapper
{
    public static final ObjectMapper INSTANCE = new ObjectMapper();

    private Mapper() {}
}
