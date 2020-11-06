package pers.paopa.jdbc.simple;

import java.sql.*;

public class ResultSetCloseTest {

    private static String host = "localhost";
    private static String port = "5432";
    private static String database = "workspace";
    private static String username = "workspace";
    private static String password = "123qwe";
    private static String sql = "select * from test;";

    public static void main(String[] args) {
        demo();
        while (true) ;
    }

    private static void demo() {
        try (Connection connection = generateConnection();
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        while(true){
            System.out.println(123);
        }
    }

    private static Connection generateConnection() throws ClassNotFoundException, SQLException {
        String connectionUrl = "jdbc:postgresql://" + host + ":" + port + "/" + database;
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(connectionUrl, username, password);
    }
}
