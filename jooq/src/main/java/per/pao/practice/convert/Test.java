package per.pao.practice.convert;

import org.jooq.DSLContext;
import per.pao.practice.entity.tables.Author;
import per.pao.practice.entity.tables.records.AuthorRecord;
import per.pao.practice.tool.ConnectionFactory;
import per.pao.practice.tool.DSLFactory;

import java.sql.Connection;

public class Test
{
    public static void main(String[] args)
    {
        try (Connection connection = ConnectionFactory.generate()) {
            final DSLContext context = DSLFactory.create(connection);
            final AuthorRecord author = context.select().from(Author.AUTHOR).where("id = 1")
                    .fetchOptionalInto(AuthorRecord.class).get();
            final per.pao.practice.entity.tables.pojos.Author pojo =
                    author.into(per.pao.practice.entity.tables.pojos.Author.class);
            System.out.println(pojo);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
