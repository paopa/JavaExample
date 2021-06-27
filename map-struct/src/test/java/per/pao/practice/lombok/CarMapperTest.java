package per.pao.practice.lombok;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest
{
    @Test
    void toDto()
    {
        Car.Entity entity = new Car.Entity(1, "car entity");
        Car.Dto dto = CarMapper.INSTANCE.toDto(entity);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }
}