package per.pao.practice.map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import per.pao.practice.util.Mapper;

import java.util.Map;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        final Map<String, Object> map = Mapper.INSTANCE.readValue(json, new TypeReference<>() {});
        System.out.println(map);
    }
}