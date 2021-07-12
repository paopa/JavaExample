package per.pao.practice.node;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;
import per.pao.practice.util.Mapper;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        final String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        final JsonNode node = Mapper.INSTANCE.readTree(json);
        System.out.println(node.get("color").toString());
        System.out.println(node.get("type").toString());
    }
}

@Data
class Car
{
    private String color;
    private String type;
}
