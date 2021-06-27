package per.pao.practice.sub;

public class Employee
{
    public static class Entity
    {
        private final int id;
        private final String name;
        private final Division.Entity division;

        public Entity(int id, String name, Division.Entity division)
        {
            this.id = id;
            this.name = name;
            this.division = division;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }

        public Division.Entity getDivision()
        {
            return division;
        }
    }

    public static class Dto
    {
        private final int employeeId;
        private final String employeeName;
        private final Division.Dto division;

        public Dto(int employeeId, String employeeName, Division.Dto division)
        {
            this.employeeId = employeeId;
            this.employeeName = employeeName;
            this.division = division;
        }

        public int getEmployeeId()
        {
            return employeeId;
        }

        public String getEmployeeName()
        {
            return employeeName;
        }

        public Division.Dto getDivision()
        {
            return division;
        }
    }
}
