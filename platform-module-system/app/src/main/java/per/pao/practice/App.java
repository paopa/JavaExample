package per.pao.practice;

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
        loader.forEach(service->service.sayHello());
//        final IHello service = loader.findFirst().get();
//        service.sayHello();
    }
}
