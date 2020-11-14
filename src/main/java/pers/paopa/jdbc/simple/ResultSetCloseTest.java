package pers.paopa.jdbc.simple;

import java.sql.*;

import static pers.paopa.jdbc.simple.JdbcTest.generateConnection;

public class ResultSetCloseTest {

    private static String sql = "select * from test;";

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try (Connection connection = generateConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println(resultSet.getLong(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
