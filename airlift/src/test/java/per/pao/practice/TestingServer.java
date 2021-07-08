package per.pao.practice;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.inject.Injector;
import com.google.inject.Module;
import io.airlift.bootstrap.Bootstrap;
import io.airlift.event.client.EventModule;
import io.airlift.http.server.HttpServer;
import io.airlift.http.server.testing.TestingHttpServer;
import io.airlift.http.server.testing.TestingHttpServerModule;
import io.airlift.jaxrs.JaxrsModule;
import io.airlift.json.JsonModule;
import io.airlift.node.NodeModule;

import java.util.List;
import java.util.Map;

public class TestingServer
{
    private TestingServer() {}

    public static HttpServer create(List<Module> list)
    {
        ImmutableList<Module> modules = ImmutableList.<Module>builder()
                .add(new TestingHttpServerModule(8080),
                        new NodeModule(),
                        new EventModule(),
                        new JsonModule(),
                        new JaxrsModule())
                .addAll(list)
                .build();
        Bootstrap app = new Bootstrap(modules);
        Map<String, String> properties = ImmutableMap.<String, String>builder()
                .put("node.environment", "test")
                .build();
        Injector injector = app.strictConfig()
                .setOptionalConfigurationProperties(properties)
                .initialize();
        return injector.getInstance(TestingHttpServer.class);
    }
}
