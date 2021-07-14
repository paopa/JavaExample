package per.pao.practice;

import java.util.ServiceLoader;

public class App
{
    public static void main(String[] args)
    {
        final ServiceLoader<Animal> loader = ServiceLoader.load(Animal.class);
        loader.iterator().forEachRemaining(provider -> provider.eat());
    }
}
