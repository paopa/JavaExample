package per.pao.practice.annotation.raw;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class TestRaw
{
    @Test
    public void test()
            throws JsonProcessingException
    {
        final Raw raw = new Raw("testing bean", "{\"attr\":false}");
        final String json = Mapper.INSTANCE.writeValueAsString(raw);
        System.out.println(json);
        assertThat(json, containsString("testing bean"));
        assertThat(json, containsString("{\"attr\":false}"));
    }
}