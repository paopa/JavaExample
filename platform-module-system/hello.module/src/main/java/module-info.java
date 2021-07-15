module platform.module.system.hello.module {
    exports per.pao.modules.hello;
//    exports per.pao.modules.test;
    provides per.pao.modules.hello.IHello
            with per.pao.modules.hello.HelloImpl;

    exports per.pao.modules.api.player;
    provides per.pao.modules.api.player.Player
            with per.pao.modules.impl.player.ConsolePlayer;
    uses per.pao.modules.api.player.Player;
}