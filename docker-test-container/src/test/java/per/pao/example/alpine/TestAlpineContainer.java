package per.pao.example.alpine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.util.Objects.isNull;

@Testable
@Testcontainers
public class TestAlpineContainer
{
    @Container
    public static final GenericContainer container =
            new GenericContainer("alpine:3.2")
                    .withExposedPorts(80)
                    .withCommand(
                            "/bin/sh",
                            "-c",
                            "while true; do echo \"HTTP/1.1 200 OK\n\nHello World!!\" | nc -l -p 80; done;");

    @org.junit.jupiter.api.Test
    @DisplayName("alpine container test")
    public void test()
            throws Exception
    {
        String expected = "Hello World!!";
        String actual = getRequest(String.format("http://%s:%s",
                container.getContainerIpAddress(),
                container.getMappedPort(80)));
        Assertions.assertEquals(expected, actual);
    }

    private String getRequest(String host)
            throws Exception
    {
        URL url = new URL(host);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        StringBuilder builder = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while (!isNull(line = in.readLine())) {
                builder.append(line);
            }
        }
        return builder.toString();
    }
}
