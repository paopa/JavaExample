package per.pao.practice.type.conversion;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper
{
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mappings({
            @Mapping(target = "employeeStartAt", source = "entity.startAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Employee.Dto entityToDto(Employee.Entity entity);

    @Mappings({
            @Mapping(target = "startAt", source = "dto.employeeStartAt", dateFormat = "dd-MM-yyyy HH:mm:ss")
    })
    Employee.Entity dtoToEntity(Employee.Dto dto);
}
