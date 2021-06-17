package pre.pao.example.provide;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class Test
{

    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new BasicModule());
        Communication instance = injector.getInstance(Communication.class);
        instance.sendMessage("do do do do~~~");
        injector.getBindings().forEach((key, value) -> {
            log.info("key:{}", value.getKey());
            log.info("provide:{}", value.getProvider().get().getClass());
            log.info("***************");
        });
    }
}

interface Communicator
{
    boolean sendMessage(String message);

    @Slf4j
    final class DefaultCommunicator
            implements Communicator
    {
        @Override
        public boolean sendMessage(String message)
        {
            log.info(message);
            return true;
        }
    }
}

@Slf4j
final class Communication
{

    @Inject @Named("c1")
    private Communicator communicator;

    @Inject @Named("c2")
    private Communicator communicator2;

    public Communication(Boolean keepRecord)
    {
        if (keepRecord) {
            log.info("Message logging enabled");
        }
    }

    public void sendMessage(String message)
    {
        communicator.sendMessage(message);
        communicator2.sendMessage(message + "2");
    }
}

final class BasicModule
        extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Communication.class)
                .toInstance(new Communication(true));
    }

    @Provides
    @Singleton
    @Named("c1")
    public Communicator getCommunicator()
    {
        return new Communicator.DefaultCommunicator();
    }

    @Provides
    @Singleton
    @Named("c2")
    public Communicator getCommunicator2()
    {
        return new Communicator.DefaultCommunicator();
    }
}

