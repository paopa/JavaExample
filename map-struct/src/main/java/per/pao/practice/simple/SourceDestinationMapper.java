package per.pao.practice.simple;

import org.mapstruct.Mapper;

@Mapper
public interface SourceDestinationMapper
{
    Destination sourceToDestination(Source source);

    Source destinationToSource(Destination destination);
}
