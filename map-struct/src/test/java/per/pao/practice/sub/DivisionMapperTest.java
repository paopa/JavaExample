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
        Employee.Entity entity = new Employee.Entity(1, "DDD", new Division.Entity(2, "DDDD"));
        Employee.Dto dto = EmployeeMapper.INSTANCE.entityToDto(entity);
        Assertions.assertEquals(entity.getId(), dto.getEmployeeId());
        Assertions.assertEquals(entity.getName(), dto.getEmployeeName());
        Assertions.assertEquals(entity.getDivision().getId(), dto.getDivision().getId());
        Assertions.assertEquals(entity.getDivision().getName(), dto.getDivision().getName());
    }

    @Test
    @DisplayName("test dto to entity")
    public void testDtoToEntity()
    {
        Employee.Dto dto = new Employee.Dto(1, "DDD", new Division.Dto(2, "DDDD"));
        Employee.Entity entity = EmployeeMapper.INSTANCE.dtoToEntity(dto);
        Assertions.assertEquals(dto.getEmployeeId(), entity.getId());
        Assertions.assertEquals(dto.getEmployeeName(), entity.getName());
        Assertions.assertEquals(dto.getDivision().getId(), entity.getDivision().getId());
        Assertions.assertEquals(dto.getDivision().getName(), entity.getDivision().getName());
    }
}