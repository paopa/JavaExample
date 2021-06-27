package per.pao.practice.before.and.after;

public class Car
{
    public static class Entity
    {
        private final int id;
        private final String name;

        public Entity(int id, String name)
        {
            this.id = id;
            this.name = name;
        }

        public int getId()
        {
            return id;
        }

        public String getName()
        {
            return name;
        }
    }

    public enum FuelType
    {
        BIO_DIESEL, ELECTRIC
    }

    public static class Dto
    {
        private final int id;
        private String name;
        private FuelType type;

        public Dto(int id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public FuelType getType()
        {
            return type;
        }

        public void setType(FuelType type)
        {
            this.type = type;
        }
    }

    public static class BioDieselCar
            extends Entity
    {
        public BioDieselCar(int id, String name)
        {
            super(id, name);
        }
    }

    public static class ElectricCar
            extends Entity
    {
        public ElectricCar(int id, String name)
        {
            super(id, name);
        }
    }
}
