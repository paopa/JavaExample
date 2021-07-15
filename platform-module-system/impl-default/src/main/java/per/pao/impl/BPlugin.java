package per.pao.impl;

import per.pao.api.plugin.Plugin;

public class BPlugin
        implements Plugin
{
    @Override
    public void start()
    {
        System.out.println("B-plugin start");
    }
}
