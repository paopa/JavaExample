package pre.pao.example.nullable;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Nullable;

public final class Test
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new AbstractModule()
        {
            @Override
            protected void configure()
            {
//                bind(DefaultPrinter.class).toProvider(() -> new DefaultPrinter());
                bind(DefaultPrinter.class).toProvider(() -> null);
            }
        });
        Processor instance = injector.getInstance(Processor.class);
        System.out.println("break point");
    }
}

final class Processor
{
    @Inject @Nullable
    private DefaultPrinter printer;
}

@Slf4j
final class DefaultPrinter {}