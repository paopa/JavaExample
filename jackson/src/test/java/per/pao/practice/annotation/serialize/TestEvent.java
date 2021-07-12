package per.pao.practice.annotation.serialize;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

class TestEvent
{
    private static final SimpleDateFormat formatter
            = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");

    @Test
    public void test()
            throws ParseException, JsonProcessingException
    {
        final String text = "30-06-2021 02:30:59";
        final Date date = formatter.parse(text);
        final Event event = new Event("testing event", date);
        final String json = Mapper.INSTANCE.writeValueAsString(event);
        System.out.println(json);
        assertThat(json, containsString(text));
    }
}