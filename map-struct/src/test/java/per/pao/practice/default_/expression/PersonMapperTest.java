package per.pao.practice.default_.expression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import per.pao.practice.default_.expression.Person.*;

class PersonMapperTest
{
    @Test
    void toDto()
    {
        Entity entity = new Entity(null, "entity name");
        Dto dto = PersonMapper.INSTANCE.toDto(entity);
        assertNotNull(dto.getUuid());
        assertEquals(entity.getName(), dto.getName());
    }
}