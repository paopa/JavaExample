package per.pao.practice.use;

import org.junit.jupiter.api.Test;
import per.pao.practice.use.Data.*;

import static org.junit.jupiter.api.Assertions.*;

class BaseMapperTest
{
    @Test
    void toDto()
    {
        final Entity entity = new Entity("123");
        final Dto dto = DataMapper.INSTANCE.toDto(entity);
        assertEquals(entity.getValue(), dto.getValue1());
        assertEquals("prefix-" + entity.getValue(), dto.getValue2());
    }
}