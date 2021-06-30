package per.pao.practice.use;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

public class Data
{
    @lombok.Data
    public static final class Entity
    {
        private final String value;
    }

    @lombok.Data
    public static final class Dto
    {
        private final String value1;
        private final String value2;
    }

    @Mapper(uses = BaseMapper.class)
    public interface DataMapper
    {
        DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

        @Mappings({
                @Mapping(source = "entity.value", target = "value1"),
                @Mapping(source = "entity.value", target = "value2", qualifiedByName = "addPrefix"),
        })
        Dto toDto(Entity entity);
    }

}