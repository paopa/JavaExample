package per.pao.practice.type.conversion;

import java.util.Date;

public class Employee
{
    public static class Entity
    {
        private final Date startAt;

        public Entity(Date startAt)
        {
            this.startAt = startAt;
        }

        public Date getStartAt()
        {
            return startAt;
        }
    }

    public static class Dto
    {
        private final String employeeStartAt;

        public Dto(String employeeStartAt)
        {
            this.employeeStartAt = employeeStartAt;
        }

        public String getEmployeeStartAt()
        {
            return employeeStartAt;
        }
    }
}
