package per.pao.practice.sub;

public class EmployeeDto
{
    private final int employeeId;
    private final String employeeName;
    private final Division.Dto division;

    public EmployeeDto(int employeeId, String employeeName, Division.Dto division)
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
