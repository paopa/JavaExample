package per.pao.practice.sub;

public class Division
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

    public static class Dto
    {
        private final int id;
        private final String name;

        public Dto(int id, String name)
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
}
