package per.pao.practice.abstract_;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import per.pao.practice.abstract_.Transaction.Dto;
import per.pao.practice.abstract_.Transaction.Entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class AbstractTransactionMapperTest
{

    @Test
    void toDtos()
    {
        Collection<Entity> collection = new ArrayList<>()
        {{
            add(new Entity(1L, new BigDecimal(100)));
            add(new Entity(2L, new BigDecimal(200)));
        }};

        List<Dto> dtos = AbstractTransactionMapper.INSTANCE.toDtos(collection);
        Assertions.assertEquals(collection.size(), dtos.size());
    }
}