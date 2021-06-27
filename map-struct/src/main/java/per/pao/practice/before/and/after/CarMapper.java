package per.pao.practice.before.and.after;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import per.pao.practice.before.and.after.Car.*;

@Mapper
public interface CarMapper
{
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    @BeforeMapping
    default void enrichDtoWithFuelType(Entity entity, @MappingTarget Dto dto)
    {
        if (entity instanceof ElectricCar) {
            dto.setType(FuelType.ELECTRIC);
            return;
        }
        if (entity instanceof BioDieselCar) {
            dto.setType(FuelType.BIO_DIESEL);
        }
    }

    @AfterMapping
    default void convertNameToUpperCase(@MappingTarget Dto dto)
    {
        dto.setName(dto.getName().toUpperCase());
    }

    Dto toDto(Entity entity);
}
