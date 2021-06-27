package per.pao.practice.sub;

public class Employee
{
    private final int id;
    private final String name;
    private final Division.Entity division;

    public Employee(int id, String name, Division.Entity division)
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
