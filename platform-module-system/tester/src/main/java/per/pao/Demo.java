package per.pao;

import per.pao.api.Provider;
import per.pao.api.plugin.Plugin;

public class Demo
{
    public static void main(String[] args)
    {
        final Plugin plugin = Provider.provide(Plugin.class, "APlugin");
        plugin.start();
        Provider.provide(Plugin.class, "BPlugin").start();
        Provider.provide(Plugin.class, "CPlugin").start();
    }
}
