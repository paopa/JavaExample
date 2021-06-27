package per.pao.practice.specified.conversion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import per.pao.practice.specified.conversion.UserBody.*;

@Mapper
public interface UserBodyMapper
{
    UserBodyMapper INSTANCE = Mappers.getMapper(UserBodyMapper.class);

    @Mapping(target = "centimeter", source = "inch", qualifiedByName = "inchToCentimeter")
    Values toValues(ImperialValuesDto dto);

    @Named("inchToCentimeter")
    default double inchToCentimeter(int inch)
    {
        return inch * 2.54;
    }
}
