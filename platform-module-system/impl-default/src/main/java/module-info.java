import per.pao.api.plugin.Plugin;
import per.pao.impl.APlugin;
import per.pao.impl.BPlugin;

module platform.module.system.impl.default_ {
    requires platform.module.system.api;
    provides Plugin with APlugin, BPlugin;
}