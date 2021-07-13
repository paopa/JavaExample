package per.pao.practice.module.config;

import io.airlift.configuration.Config;

import javax.validation.constraints.NotBlank;

/**
 * @see <a href=https://github.com/airlift/airlift/blob/master/docs/add_config.md>airlift add config</a>
 */
public class SampleConfig
{
    private String helloMessage = "hello airlift~~";

    @NotBlank
    public String getHelloMessage()
    {
        return this.helloMessage;
    }

    @Config("hello.message")
    public SampleConfig setHelloMessage(String message)
    {
        this.helloMessage = message;
        return this;
    }
}
