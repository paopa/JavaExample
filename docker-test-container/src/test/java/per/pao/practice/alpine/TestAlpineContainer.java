package per.pao.practice.alpine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import per.pao.practice.tools.WebTool;

import static per.pao.practice.tools.WebTool.request;

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

    @Test
    @DisplayName("alpine container test")
    public void test()
            throws Exception
    {
        String expected = "Hello World!!";
        String address = String.format("http://%s:%s",
                container.getContainerIpAddress(),
                container.getMappedPort(80));
        String actual = request(WebTool.HttpMethod.GET, address);
        Assertions.assertEquals(expected, actual);
    }
}
