package per.pao.practice.resource;

import org.glassfish.jersey.server.ChunkedOutput;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.CompletionCallback;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;

@Path("/v1/sample")
public class SampleResource
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello()
    {
        return "hello Airlift";
    }

    @GET
    @Path("/async")
    @Produces(MediaType.APPLICATION_JSON)
    public void helloAsync(@Suspended AsyncResponse response)
            throws Exception
    {
        response.resume("hello~~~");
    }

    @GET
    @Path("/async-sleep")
    @Produces(MediaType.APPLICATION_JSON)
    public void asyncHelloWithSleep(@Suspended AsyncResponse response)
    {
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.resume("hello!!~");
        });
        System.out.println("method asyncHelloWithSleep end");
    }

    @GET
    @Path("/async-timeout")
    @Produces(MediaType.APPLICATION_JSON)
    public void asyncHelloWithTimeout(@Suspended final AsyncResponse response)
    {
        response.setTimeoutHandler(self ->
                self.resume(Response.status(Response.Status.SERVICE_UNAVAILABLE)
                        .entity("Operation time out.").build()));
        response.setTimeout(20, TimeUnit.MILLISECONDS);
        CompletableFuture.runAsync(() -> {
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            response.resume("hello!!");
        });
    }

    @GET
    @Path("/async-callback")
    @Produces(MediaType.APPLICATION_JSON)
    public void asyncHelloWithCallback(@Suspended final AsyncResponse response)
    {
        response.register((CompletionCallback) throwable -> {
            if (isNull(throwable)) {
                System.out.println("completion callback");
                return;
            }
            throwable.printStackTrace();
        });
        CompletableFuture.runAsync(() -> {
            System.out.println("before resume");
            response.resume("hello!!");
        });
    }

    @GET
    @Path("/async-chunked")
    @Produces(MediaType.APPLICATION_JSON)
    public ChunkedOutput<String> asyncHelloWithChunked()
    {
        final ChunkedOutput<String> output = new ChunkedOutput<>(String.class);
        CompletableFuture.runAsync(() -> {
            try (output) {
                List.of('h', 'e', 'l', 'l', 'o', '!', '!').forEach(character -> {
                    try {
                        Thread.sleep(1000);
                        System.out.println(character);
                        output.write(String.valueOf(character));
                    }
                    catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                });
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        });
        return output;
    }
}
