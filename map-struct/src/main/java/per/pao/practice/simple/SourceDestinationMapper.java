package per.pao.practice.simple;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "jsr330")
@Mapper
public interface SourceDestinationMapper
{
    SourceDestinationMapper INSTANCE = Mappers.getMapper(SourceDestinationMapper.class);

    Destination sourceToDestination(Source source);

    Source destinationToSource(Destination destination);
}
