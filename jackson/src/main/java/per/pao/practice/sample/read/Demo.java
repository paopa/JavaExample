package per.pao.practice.sample.read;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import per.pao.practice.util.Mapper;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        String json = "{\"color\":\"testing-color\",\"type\":\"testing-type\"}";
        final Car car = Mapper.INSTANCE.readValue(json, Car.class);
        System.out.println(car.toString());
    }
}

@Data
class Car
{
    private String color;
    private String type;
}