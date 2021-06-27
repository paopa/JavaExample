package per.pao.practice.type.conversion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMapperTest
{
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    @Test
    void testEntityToDto()
            throws Exception
    {
        Employee.Entity entity = new Employee.Entity(new Date());
        Employee.Dto dto = EmployeeMapper.INSTANCE.entityToDto(entity);
        Assertions.assertEquals(
                entity.getStartAt().toString(),
                formatter.parse(dto.getEmployeeStartAt()).toString());
    }

    @Test
    void testDtoToEntity()
            throws Exception
    {
        Employee.Dto dto = new Employee.Dto("06-27-2021 23:59:59");
        Employee.Entity entity = EmployeeMapper.INSTANCE.dtoToEntity(dto);
        System.out.println(formatter.parse(dto.getEmployeeStartAt()).toString());
        Assertions.assertEquals(
                formatter.parse(dto.getEmployeeStartAt()).toString(),
                entity.getStartAt().toString());
    }
}