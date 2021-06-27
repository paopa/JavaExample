package per.pao.practice.specified.conversion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import per.pao.practice.specified.conversion.UserBody.*;

class UserBodyMapperTest
{
    @Test
    void toValues()
    {
        ImperialValuesDto dto = new ImperialValuesDto(100, 100);
        Values values = UserBodyMapper.INSTANCE.toValues(dto);
        assertNotNull(values);
        assertEquals(dto.getInch() * 2.54, values.getCentimeter());
        assertEquals(dto.getPound() * 0.435, values.getKilogram());
    }
}