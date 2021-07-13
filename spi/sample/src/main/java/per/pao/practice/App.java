package per.pao.practice;

import java.util.ServiceLoader;

public class App
{
    public static void main(String[] args)
    {
        final ServiceLoader<Animal> LOADER = ServiceLoader.load(Animal.class);
        LOADER.iterator().forEachRemaining(provider -> provider.eat());
    }
}
