package per.pao.practice.sub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DivisionMapperTest
{
    @Test
    @DisplayName("test entity to dto")
    public void testEntityToDto()
    {
        Employee entity = new Employee(1, "DDD", new Division.Entity(2, "DDDD"));
        EmployeeDto dto = EmployeeMapper.INSTANCE.entityToDto(entity);
        Assertions.assertEquals(entity.getId(), dto.getEmployeeId());
        Assertions.assertEquals(entity.getName(), dto.getEmployeeName());
        Assertions.assertEquals(entity.getDivision().getId(), dto.getDivision().getId());
        Assertions.assertEquals(entity.getDivision().getName(), dto.getDivision().getName());
    }

    @Test
    @DisplayName("test dto to entity")
    public void testDtoToEntity()
    {
        EmployeeDto dto = new EmployeeDto(1, "DDD", new Division.Dto(2, "DDDD"));
        Employee entity = EmployeeMapper.INSTANCE.dtoToEntity(dto);
        Assertions.assertEquals(dto.getEmployeeId(), entity.getId());
        Assertions.assertEquals(dto.getEmployeeName(), entity.getName());
        Assertions.assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        Assertions.assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
    }
}