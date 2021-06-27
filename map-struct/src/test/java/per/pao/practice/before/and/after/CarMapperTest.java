package per.pao.practice.before.and.after;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class CarMapperTest
{
    @Test
    void toDto()
    {
        Car.Entity entity = new Car.BioDieselCar(1, "small car");
        Car.Dto dto = CarMapper.INSTANCE.toDto(entity);
        Assertions.assertEquals(entity.getName().toUpperCase(Locale.ROOT), dto.getName());
        Assertions.assertEquals(Car.FuelType.BIO_DIESEL, dto.getType());
    }
}