package per.pao.practice.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/sample")
public class SampleResource
{
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello()
    {
        return "hello Airlift";
    }
}
