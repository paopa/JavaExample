package per.pao.modules.api.player;

import java.util.ServiceLoader;

public interface Player
{
    void play(String video);

    static Player provide(String name)
    {
        return ServiceLoader.load(Player.class)
                .stream()
                .filter(provider -> provider.get().getClass().getSimpleName().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("service %s not found", name)))
                .get();
    }
}
