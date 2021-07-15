import per.pao.api.plugin.Plugin;
import per.pao.impl.plugin.c.CPlugin;

module platform.module.system.impl.plugin.c {
    requires platform.module.system.api;
    provides Plugin with CPlugin;
}