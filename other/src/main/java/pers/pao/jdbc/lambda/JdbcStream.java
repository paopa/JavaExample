package pers.pao.jdbc.lambda;

import java.sql.*;
import java.util.List;

public class JdbcStream {

    private final static String sql = "select * from tb_c59eb968b98d49f69bbf20bfb16abdc4";
    private static String user ;
    private static String password ;
    private static String url = "jdbc:postgresql://host:port/database?currentSchema=schema";
    private final static List<String> columnNames = List.of("c0", "c1", "c2");

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        test(args);
        long end = System.currentTimeMillis();
        System.out.println("cost: " + (end - start) + " ms");
    }

    private static void test(String[] args) {
        init(args);
        try (Connection connection = generateConnection()) {
            connection.setAutoCommit(false);
            prepareStatement(connection);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void init(String[] args) {
        user = args[0];
        password = args[1];
        url = url.replace("host", args[2])
                .replace("port", args[3])
                .replace("database", args[4])
                .replace("schema", args[5]);
    }

    private static void prepareStatement(Connection connection) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)) {
            ps.setFetchSize(1000);
            executeSql(ps);
        }
    }

    private static void executeSql(PreparedStatement ps) throws SQLException {
        try (ResultSet rs = ps.executeQuery()) {
            int index = 0;
            while (rs.next()) {
                if (index % 10000 == 0) {
                    System.out.println("batch: " + index + " time: " + System.currentTimeMillis());
                }
                columnNames.forEach(name -> {
                    try {
                        rs.getString(name);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                });
                index++;
            }
        }
    }

    private static Connection generateConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url, user, password);
    }


//    public static void select(Connection connection,
//                              String sql,
//                              ResultSetProcessor processor,
//                              Object... params) {
//        try (PreparedStatement ps = connection.prepareStatement(sql)) {
//            int cnt = 0;
//            for (Object param : params) {
//                ps.setObject(++cnt, param);
//            }
//            try (ResultSet rs = ps.executeQuery()) {
//                long rowCnt = 0;
//                while (rs.next()) {
//                    processor.process(rs, rowCnt++);
//                }
//            } catch (SQLException e) {
//                throw new DataAccessException(e);
//            }
//        } catch (SQLException e) {
//            throw new DataAccessException(e);
//        }
//    }
}
