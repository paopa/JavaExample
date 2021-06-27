package per.pao.practice.sub;

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
    Employee.Dto entityToDto(Employee.Entity entity);

    @Mappings({
            @Mapping(target = "id", source = "dto.employeeId"),
            @Mapping(target = "name", source = "dto.employeeName")
    })
    Employee.Entity dtoToEntity(Employee.Dto dto);

    Division.Dto entityToDto(Division.Entity entity);

    Division.Entity dtoToEntity(Division.Dto dto);
}
