package per.pao.practice.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

public class MapperIntegrationTest
{
    private static final SourceDestinationMapper mapper =
            Mappers.getMapper(SourceDestinationMapper.class);

    @Test
    @DisplayName("test source to destination")
    public void testSourceToDestination()
    {
        Source source = new Source("source name", "source description");
        Destination destination = mapper.sourceToDestination(source);
        Assertions.assertEquals(source.getName(), destination.getName());
        Assertions.assertEquals(source.getDescription(), destination.getDescription());
    }
}
