package per.pao.practice.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{
    public static Connection generate(String username, String password, String database)
            throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/" + database;
        return DriverManager.getConnection(url, username, password);
    }
}
