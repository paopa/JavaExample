package per.pao.practice.configure.null_.primitive;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import lombok.Data;
import per.pao.practice.util.Mapper;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        try {
            final String json = "{ \"color\" : \"Black\", \"year\" : null }";
            Mapper.INSTANCE.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true); // default is false
            final Car car = Mapper.INSTANCE.readValue(json, Car.class);
            System.out.println(car);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

@Data
class Car
{
    private String color;
    private int year;
}
