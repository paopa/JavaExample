package per.pao.practice;

import per.pao.modules.api.player.Player;
import per.pao.modules.hello.Hello;
import per.pao.modules.hello.IHello;

import java.util.ServiceLoader;
//import per.pao.modules.test.Test;

public class App
{
    public static void main(String[] args)
    {
        // test
        Hello.print();
//        Test.print();
        // test uses ... directive
        final ServiceLoader<IHello> loader = ServiceLoader.load(IHello.class);
        final IHello service = loader.findFirst().get();
        service.sayHello();
    }
}
