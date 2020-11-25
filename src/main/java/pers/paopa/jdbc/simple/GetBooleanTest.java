package pers.paopa.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_FORWARD_ONLY;
import static pers.paopa.jdbc.simple.JdbcTest.generateConnection;

public class GetBooleanTest {

    private static String sql = "select bool from test;";

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try (Connection connection = generateConnection();
             PreparedStatement ps = connection.prepareStatement(sql, TYPE_FORWARD_ONLY, CONCUR_READ_ONLY);
             ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getBoolean(1));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
