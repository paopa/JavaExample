package per.pao.practice.array;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import lombok.Data;
import per.pao.practice.util.Mapper;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        // list
        final String jsonCarArray =
                "[{ \"color\" : \"Black\", \"type\" : \"BMW\" }, { \"color\" : \"Red\", \"type\" : \"FIAT\" }]";
        final List<Car> cars = Mapper.INSTANCE.readValue(jsonCarArray, new TypeReference<>() {});
        System.out.println(cars.toString());

        // array
        Mapper.INSTANCE.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
        final Car[] carArray = Mapper.INSTANCE.readValue(jsonCarArray, Car[].class);
        final String s = Arrays.stream(carArray).map(Car::toString).collect(joining(", ", "[", "]"));
        System.out.println(s);
    }
}

@Data
class Car
{
    private String color;
    private String type;
}
