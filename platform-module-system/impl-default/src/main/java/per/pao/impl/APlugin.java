package per.pao.impl;

import per.pao.api.plugin.Plugin;

public class APlugin
        implements Plugin
{
    @Override
    public void start()
    {
        System.out.println("A-plugin start");
    }
}
