package per.pao.practice.annotation.value;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import per.pao.practice.util.Mapper;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class TestEnum
{
    @Test
    public void test()
            throws JsonProcessingException
    {
        final String json = Mapper.INSTANCE.writeValueAsString(Enum.TYPE_A);
        System.out.println(json);
        assertThat(json, is("\"Type A\""));
    }
}