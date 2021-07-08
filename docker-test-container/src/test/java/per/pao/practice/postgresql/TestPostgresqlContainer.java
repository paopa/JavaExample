package per.pao.practice.postgresql;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.containers.JdbcDatabaseContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

@Testable
@Testcontainers
public class TestPostgresqlContainer
{
    @Container
    public static final JdbcDatabaseContainer container =
            new PostgreSQLContainer("postgres:13.3-alpine")
                    .withDatabaseName("test-db")
                    .withUsername("worker-1")
                    .withPassword("123")
                    .withInitScript("db-script/table.sql");

    @Test
    @DisplayName("test select one")
    public void testSelectOne()
            throws Exception
    {
        int actual = 0;
        String jdbcUrl = container.getJdbcUrl();
        String username = container.getUsername();
        String password = container.getPassword();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            ResultSet resultSet = connection.prepareStatement("select 1;").executeQuery();
            while (resultSet.next()) {
                actual = resultSet.getInt(1);
            }
        }
        Assertions.assertEquals(1, actual);
    }

    @Test
    @DisplayName("test select * from a")
    public void testSelectAll()
            throws Exception
    {
        int actualColumnCount = 0;
        try (Connection connection = container.createConnection("");
                ResultSet resultSet = connection.prepareStatement("select * from a;").executeQuery()) {
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " ," + resultSet.getString("s"));
            }
            actualColumnCount = resultSet.getMetaData().getColumnCount();
        }
        Assertions.assertEquals(2, actualColumnCount);
    }
}
