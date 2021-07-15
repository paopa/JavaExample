import per.pao.modules.hello.IHello;

module platform.module.system.app {
    requires platform.module.system.hello.module;
    uses IHello;
}