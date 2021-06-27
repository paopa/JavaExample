package per.pao.practice.abstract_;

import java.math.BigDecimal;
import java.util.UUID;

public class Transaction
{
    public static class Entity
    {
        private final Long id;
        private final String uuid = UUID.randomUUID().toString();
        private final BigDecimal total;

        public Entity(Long id, BigDecimal total)
        {
            this.id = id;
            this.total = total;
        }

        public Long getId()
        {
            return id;
        }

        public String getUuid()
        {
            return uuid;
        }

        public BigDecimal getTotal()
        {
            return total;
        }
    }

    public static class Dto
    {
        private final String uuid;
        private final Long totalInCent;

        public Dto(String uuid, Long totalInCent)
        {
            this.uuid = uuid;
            this.totalInCent = totalInCent;
        }

        public String getUuid()
        {
            return uuid;
        }

        public Long getTotalInCent()
        {
            return totalInCent;
        }
    }
}
