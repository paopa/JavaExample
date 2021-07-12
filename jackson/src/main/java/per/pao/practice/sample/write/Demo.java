package per.pao.practice.sample.write;

import lombok.Data;
import per.pao.practice.util.Mapper;

import java.io.IOException;

public class Demo
{
    public static void main(String[] args)
            throws IOException
    {
        final Car car = new Car();
        car.setColor("blue");
        car.setType("small");
        System.out.println(Mapper.INSTANCE.writeValueAsString(car));
    }
}

@Data
class Car
{
    private String color;
    private String type;
}
