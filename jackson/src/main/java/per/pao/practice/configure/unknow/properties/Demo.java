package per.pao.practice.configure.unknow.properties;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import per.pao.practice.util.Mapper;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        final String json = "{ \"color\" : \"Black\", \"type\" : \"Fiat\", \"year\" : \"1970\" }";
        toObject(json);
//        toNode(json);
    }

    private static void toNode(String json)
            throws JsonProcessingException
    {
        final JsonNode node = Mapper.INSTANCE.readTree(json);
        System.out.println(node.get("year").asText());
    }

    private static void toObject(String json)
            throws JsonProcessingException
    {
        Mapper.INSTANCE.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        final Car car = Mapper.INSTANCE.readValue(json, Car.class);
        System.out.println(car);
    }
}

@Data
class Car
{
    private String color;
    private String type;
}