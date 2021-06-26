package per.pao.practice.diff.name;

public class EmployeeDto
{
    private final int employeeId;
    private final String employeeName;

    public EmployeeDto(int employeeId, String employeeName)
    {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
    }

    public int getEmployeeId()
    {
        return employeeId;
    }

    public String getEmployeeName()
    {
        return employeeName;
    }
}
