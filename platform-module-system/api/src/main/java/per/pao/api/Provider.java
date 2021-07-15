package per.pao.api;

import java.util.ServiceLoader;

public interface Provider
{
    static <Plugin> Plugin provide(Class<Plugin> clazz, String name)
    {
        return ServiceLoader.load(clazz).stream()
                .filter(provider -> provider.get().getClass().getSimpleName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("service %s not found", name)))
                .get();
    }
}
