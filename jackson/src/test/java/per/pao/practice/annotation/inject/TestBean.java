package per.pao.practice.annotation.inject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

import static org.junit.jupiter.api.Assertions.*;

class TestBean
{
    @Test
    public void test()
            throws JsonProcessingException
    {
        final String json = "{\"name\":\"My bean\"}";
        final InjectableValues.Std injection
                = new InjectableValues.Std().addValue(int.class, 2);
        final Bean bean = Mapper.INSTANCE.reader(injection)
                .forType(Bean.class).readValue(json);
        System.out.println(bean);
    }
}