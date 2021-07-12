package per.pao.practice.annotation.getter;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class TestBean
{
    @Test
    public void test()
            throws JsonProcessingException
    {
        final Bean bean = new Bean(1, "testing bean");
        final String json = Mapper.INSTANCE.writeValueAsString(bean);
        System.out.println(json);
        assertThat(json, containsString("1"));
        assertThat(json, containsString("testing bean"));
    }
}