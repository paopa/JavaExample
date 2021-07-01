package per.pao.practice.tool;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory
{

    private static volatile Boolean flag = false;

    public static Connection generate(String username, String password, String database)
            throws SQLException, ClassNotFoundException
    {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost:5432/" + database;
        return DriverManager.getConnection(url, username, password);
    }

    public static Connection generate()
            throws IOException, SQLException, ClassNotFoundException
    {
        if (!flag) {
            synchronized (flag) {
                if (!flag) {
                    System.getProperties()
                            .load(new FileInputStream(System.getProperty("user.dir") + "/jooq/etc/jvm.properties"));
                    flag = true;
                }
            }
        }
        return generate(System.getProperty("user"), System.getProperty("pwd"), System.getProperty("database"));
    }
}
