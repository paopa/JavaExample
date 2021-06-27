package per.pao.practice.abstract_;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Mapper
public abstract class AbstractTransactionMapper
{
    public static final AbstractTransactionMapper INSTANCE = Mappers.getMapper(AbstractTransactionMapper.class);

    public Transaction.Dto toDto(Transaction.Entity entity)
    {
        return new Transaction.Dto(
                entity.getUuid(),
                entity.getTotal().multiply(new BigDecimal(100)).longValue());
    }

    public abstract List<Transaction.Dto> toDtos(Collection<Transaction.Entity> entities);
}
