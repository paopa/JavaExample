package per.pao.practice.sample;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import per.pao.practice.entity.tables.Author;
import per.pao.practice.tool.ConnectionFactory;

import java.sql.Connection;

public class Test
{
    public static void main(String[] args)
    {
        try (final Connection con = ConnectionFactory.generate(args[0], args[1], args[2])) {
            final DSLContext context = DSL.using(con, SQLDialect.POSTGRES);
            final Result<Record> result = context.select().from(Author.AUTHOR).fetch();
            result.forEach(row -> System.out.println(
                    row.get(Author.AUTHOR.ID) + row.get(Author.AUTHOR.FIRST_NAME) + row.get(Author.AUTHOR.LAST_NAME)));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
