package pers.pao.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_FORWARD_ONLY;
import static pers.pao.jdbc.simple.JdbcTest.generateConnection;

public class FetchSizeTest {

    private static String sql = "select * from test;";

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try (Connection connection = generateConnection()) {
            connection.setAutoCommit(false);
            try (PreparedStatement ps = connection.prepareStatement(sql, TYPE_FORWARD_ONLY, CONCUR_READ_ONLY)) {
                ps.setFetchSize(1);
                try (ResultSet resultSet = ps.executeQuery()) {

                    while (resultSet.next()) {
                        System.out.println(resultSet.getString(1));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
