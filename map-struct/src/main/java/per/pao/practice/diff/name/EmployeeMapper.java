package per.pao.practice.diff.name;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper
{
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(target = "employeeId", source = "entity.id"),
            @Mapping(target = "employeeName", source = "entity.name")
    })
    EmployeeDto entityToDto(Employee entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.employeeId"),
            @Mapping(target = "name", source = "dto.employeeName")
    })
    Employee dtoToEntity(EmployeeDto dto);
}
