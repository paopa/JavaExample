package per.pao.practice.diff.name;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EmployeeMapperTest
{
    @Test
    @DisplayName("test entity to dto")
    public void testEntityToDto()
    {
        Employee entity = new Employee(1, "DDD");
        EmployeeDto dto = EmployeeMapper.INSTANCE.entityToDto(entity);
        Assertions.assertEquals(entity.getId(), dto.getEmployeeId());
        Assertions.assertEquals(entity.getName(), dto.getEmployeeName());
    }

    @Test
    @DisplayName("test dto to entity")
    public void testDtoToEntity()
    {
        EmployeeDto dto = new EmployeeDto(1, "DDD");
        Employee entity = EmployeeMapper.INSTANCE.dtoToEntity(dto);
        Assertions.assertEquals(dto.getEmployeeId(), entity.getId());
        Assertions.assertEquals(dto.getEmployeeName(), entity.getName());
    }
}
