package per.pao.practice.annotation.creator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

class TestBean
{
    @Test
    public void test()
            throws JsonProcessingException
    {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
//        String json = "{\"id\":1,\"name\":\"My bean\"}";
        final Bean bean = Mapper.INSTANCE.readerFor(Bean.class).readValue(json);
//        final Bean bean = Mapper.INSTANCE.readValue(json, Bean.class);
        System.out.println(bean);
    }
}