package per.pao.practice.use;

import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper
public interface BaseMapper
{
    @Named("addPrefix")
    default String addPrefix(String text)
    {
        return "prefix-" + text;
    }
}
