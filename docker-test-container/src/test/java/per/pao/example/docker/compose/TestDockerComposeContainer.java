package per.pao.example.docker.compose;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.junit.jupiter.Testcontainers;
import per.pao.example.tools.WebTool;

import java.nio.file.Paths;

@Testable
@Testcontainers
public class TestDockerComposeContainer
{

    private static DockerComposeContainer container;

    @BeforeAll
    public static void setup()
            throws Exception
    {
        container = new DockerComposeContainer(
                Paths.get(TestDockerComposeContainer.class
                        .getClassLoader()
                        .getResource("docker/docker-compose.yml").toURI()).toFile())
                .withExposedService("web_1", 80);
        container.start();
    }

    @AfterAll
    public static void tearDown()
    {
        container.stop();
    }

    @Test
    public void test()
            throws Exception
    {
        String address = String.format("http://%s:%s",
                container.getServiceHost("web_1", 80),
                container.getServicePort("web_1", 80));
        String actual = WebTool.request(WebTool.HttpMethod.GET, address);
        Assertions.assertEquals("Hello World!", actual);
    }
}
