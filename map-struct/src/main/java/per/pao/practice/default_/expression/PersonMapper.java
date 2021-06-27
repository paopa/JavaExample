package per.pao.practice.default_.expression;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import per.pao.practice.default_.expression.Person.*;

@Mapper
public interface PersonMapper
{
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "uuid", source = "entity.uuid"
            , defaultExpression = "java(java.util.UUID.randomUUID().toString())")
    Dto toDto(Entity entity);
}
