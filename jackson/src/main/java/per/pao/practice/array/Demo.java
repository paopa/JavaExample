package per.pao.practice.array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;
import per.pao.practice.util.Mapper;

import java.util.List;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        final List<Car> cars = Mapper.INSTANCE.readValue(jsonCarArray, new TypeReference<>() {});
        System.out.println(cars.toString());
    }
}

@Data
class Car
{
    private String color;
    private String type;
}
