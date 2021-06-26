package per.pao.practice.cdi;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import per.pao.practice.simple.Destination;
import per.pao.practice.simple.Source;
import per.pao.practice.simple.SourceDestinationMapper;

public class TestGuice
{
    public static SourceDestinationService service;

    @BeforeAll
    public static void setup()
    {
        service = Guice.createInjector(new AbstractModule()
        {
            @Override
            protected void configure()
            {
                bind(SourceDestinationMapper.class)
                        .toInstance(SourceDestinationMapper.INSTANCE);
            }
        }).getInstance(SourceDestinationService.class);
    }

    @Test
    public void testSourceToDestination()
    {
        Source source = new Source("source name", "source description");
        Destination destination = service.sourceToDestination(source);
        Assertions.assertEquals(source.getName(), destination.getName());
        Assertions.assertEquals(source.getDescription(), destination.getDescription());
    }

    @Test
    public void testDestinationToSource()
    {
        Destination destination = new Destination("destination name", "destination description");
        Source source = service.destinationToSource(destination);
        Assertions.assertEquals(destination.getName(), source.getName());
        Assertions.assertEquals(destination.getDescription(), source.getDescription());
    }
}
