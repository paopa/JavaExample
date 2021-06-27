package per.pao.practice.specified.conversion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.Qualifier;
import org.mapstruct.factory.Mappers;
import per.pao.practice.specified.conversion.UserBody.*;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Mapper
public interface UserBodyMapper
{
    UserBodyMapper INSTANCE = Mappers.getMapper(UserBodyMapper.class);

    @Mappings({
            @Mapping(target = "centimeter", source = "inch", qualifiedByName = "inchToCentimeter"),
            @Mapping(target = "kilogram", source = "pound", qualifiedBy = PoundToKilogram.class)
    })
    Values toValues(ImperialValuesDto dto);

    @Named("inchToCentimeter")
    default double inchToCentimeter(int inch)
    {
        return inch * 2.54;
    }

    @PoundToKilogram
    default double poundToKilogram(int pound)
    {
        return pound * 0.435;
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    @interface PoundToKilogram {}
}
