package per.pao.practice.lombok;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import per.pao.practice.lombok.Car.*;

@Mapper
public interface CarMapper
{
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    Dto toDto(Entity entity);
}
