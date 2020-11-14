package pers.paopa.jdbc.simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

    private static String connectionUrl = "jdbc:postgresql://%s:%s/%s";
    private static String host = "localhost";
    private static String port = "5432";
    private static String username = "workspace";
    private static String password = "123qwe";
    private static String database = "workspace";


    public static Connection generateConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(String.format(connectionUrl, host, port, database), username, password);
    }
}
