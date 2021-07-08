package per.pao.practice.resource;

import com.google.common.collect.ImmutableList;
import io.airlift.http.server.HttpServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import per.pao.practice.TestingServer;
import per.pao.practice.module.SampleModule;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;

class SampleResourceTest
{
    private static HttpServer server;

    @BeforeAll
    static void setUp()
    {
        server = TestingServer.create(ImmutableList.of(new SampleModule()));
    }

    @AfterAll
    static void tearDown()
            throws Exception
    {
        server.stop();
    }

    @Test
    public void test()
            throws IOException, InterruptedException
    {
        final HttpClient client = HttpClient.newBuilder().build();
        final HttpResponse<String> response = client.send(
                HttpRequest.newBuilder().GET().uri(URI.create("http://localhost:8080/v1/sample")).build(),
                HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        assertThat(response.body()).isEqualTo("hello Airlift");
    }

    @Test
    public void testWithClientBuilder()
    {
        final Client client = ClientBuilder.newClient();
        final WebTarget target = client.target("http://localhost:8080/");
        final String actual = target.path("v1/sample").request().get(String.class);
        System.out.println(actual);
        assertThat(actual).isEqualTo("hello Airlift");
    }
}