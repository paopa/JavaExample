package per.pao.practice.annotation.any;

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
        final Bean bean = new Bean("my bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");
        final String json = Mapper.INSTANCE.writeValueAsString(bean);
        System.out.println(json);

        assertThat(json, containsString("attr1"));
        assertThat(json, containsString("attr2"));
    }
}