package per.pao.practice.cdi;

import com.google.inject.Inject;
import per.pao.practice.simple.Destination;
import per.pao.practice.simple.Source;
import per.pao.practice.simple.SourceDestinationMapper;

public class SourceDestinationService
        implements SourceDestinationMapper
{
    @Inject
    private SourceDestinationMapper mapper;

    @Override
    public Destination sourceToDestination(Source source)
    {
        return mapper.sourceToDestination(source);
    }

    @Override
    public Source destinationToSource(Destination destination)
    {
        return mapper.destinationToSource(destination);
    }
}
