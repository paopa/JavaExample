package per.pao.practice.tool;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DSLFactory
{
    public static DSLContext create(Connection connection, SQLDialect sqlDialect)
            throws SQLException, IOException, ClassNotFoundException
    {
        return DSL.using(connection, sqlDialect);
    }

    public static DSLContext create(Connection connection)
            throws SQLException, IOException, ClassNotFoundException
    {
        return create(connection, SQLDialect.POSTGRES);
    }
}
