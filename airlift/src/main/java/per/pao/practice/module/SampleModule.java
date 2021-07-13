package per.pao.practice.module;

import com.google.inject.Binder;
import com.google.inject.Module;
import io.airlift.configuration.ConfigBinder;
import io.airlift.jaxrs.JaxrsBinder;
import per.pao.practice.module.config.SampleConfig;
import per.pao.practice.resource.SampleResource;

public class SampleModule
        implements Module
{
    @Override
    public void configure(Binder binder)
    {
        JaxrsBinder.jaxrsBinder(binder).bind(SampleResource.class);
        ConfigBinder.configBinder(binder).bindConfig(SampleConfig.class);
    }
}
