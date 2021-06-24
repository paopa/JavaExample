package per.pao.example.postgresql;

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
                    .withInitScript("table/table.sql");

    @Test
    @DisplayName("test select one")
    public void testSelectOne()
            throws Exception
    {
        String jdbcUrl = container.getJdbcUrl();
        String username = container.getUsername();
        String password = container.getPassword();
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            ResultSet resultSet = connection.prepareStatement("select 1;").executeQuery();
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1));
            }
        }
    }
}
