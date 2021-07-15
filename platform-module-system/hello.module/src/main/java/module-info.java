module platform.module.system.hello.module {
    exports per.pao.modules.hello;
//    exports per.pao.modules.test;
    provides per.pao.modules.hello.IHello
            with per.pao.modules.hello.HelloImpl;
}