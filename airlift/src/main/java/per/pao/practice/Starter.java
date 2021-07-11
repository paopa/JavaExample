package per.pao.practice;

import io.airlift.bootstrap.Bootstrap;
import io.airlift.event.client.EventModule;
import io.airlift.http.server.HttpServerModule;
import io.airlift.jaxrs.JaxrsModule;
import io.airlift.json.JsonModule;
import io.airlift.node.NodeModule;
import per.pao.practice.module.SampleModule;

public class Starter
{
    public static void main(String[] args)
    {
        final Bootstrap bootstrap = new Bootstrap(
                new SampleModule(),
                new NodeModule(),
                new HttpServerModule(),
                new EventModule(),
                new JsonModule(),
                new JaxrsModule());
        bootstrap.strictConfig().initialize();
    }

    private Starter() {}
}
