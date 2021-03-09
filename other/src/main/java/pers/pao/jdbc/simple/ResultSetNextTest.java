package pers.pao.jdbc.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.apache.commons.lang3.BooleanUtils.isTrue;
import static pers.pao.jdbc.simple.JdbcTest.generateConnection;

public class ResultSetNextTest {

    private static String sql = "select * from test;";

    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        try (Connection conn = generateConnection();
             PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
             ResultSet rs = ps.executeQuery()) {
            boolean hasNext = rs.next();
            while (isTrue(hasNext)) {
                int size = rs.getMetaData().getColumnCount();
                for (int i = 1; i <= size; i++) {
                    System.out.print(rs.getString(i) + " ");
                }
                System.out.println();
                if (!rs.next()) {
                    break;
                }
            }
            System.out.println("end");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
