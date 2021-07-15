package per.pao.impl.plugin.c;

import per.pao.api.plugin.Plugin;

public class CPlugin
        implements Plugin
{
    @Override
    public void start()
    {
        System.out.println("C-plugin start");
    }
}
