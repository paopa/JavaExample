package per.pao.practice.date;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Data;
import per.pao.practice.util.Mapper;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Demo
{
    public static void main(String[] args)
            throws JsonProcessingException
    {
        final Request request = new Request(new Car("yellow", "yellow"), Date.from(Instant.now()));
        final String json = Mapper.INSTANCE.writeValueAsString(request);
        System.out.println(json);

        Mapper.INSTANCE.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm a z"));
        final String json2 = Mapper.INSTANCE.writeValueAsString(request);
        System.out.println(json2);
    }
}

@Data
class Request
{
    private final Car car;
    private final Date date;
}

@Data
class Car
{
    private final String color;
    private final String type;
}
