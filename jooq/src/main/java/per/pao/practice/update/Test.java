package per.pao.practice.update;

import org.jooq.DSLContext;
import per.pao.practice.entity.Tables;
import per.pao.practice.entity.tables.pojos.Author;
import per.pao.practice.entity.tables.records.AuthorRecord;
import per.pao.practice.tool.ConnectionFactory;
import per.pao.practice.tool.DSLFactory;

import java.sql.Connection;

import static per.pao.practice.entity.tables.Author.AUTHOR;

public class Test
{
    public static void main(String[] args)
    {
        try (Connection con = ConnectionFactory.generate()) {
            final DSLContext context = DSLFactory.create(con);
            final Author record = context.select().from(AUTHOR).where("id = 1").fetchInto(Author.class).get(0);
            System.out.println(record.toString());
            record.setFirstName(record.getFirstName() + "d");
            context.executeUpdate(new AuthorRecord(record.getId(), record.getFirstName(), record.getLastName()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
