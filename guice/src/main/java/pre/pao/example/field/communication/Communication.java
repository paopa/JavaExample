package pre.pao.example.field.communication;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Communication
{

    @Inject @Named("DefaultCommunicator")
    private Communicator communicator;

    public Communication(Boolean keepRecord)
    {
        if (keepRecord) {
            log.info("Message logging enabled");
        }
    }

    public boolean sendMessage(String message)
    {
        return communicator.sendMessage(message);
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

final class BasicModule
        extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Communicator.class)
                .annotatedWith(Names.named("DefaultCommunicator"))
                .to(Communicator.DefaultCommunicator.class);
        bind(Communication.class)
                .toInstance(new Communication(true));
    }
}

final class Test
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new BasicModule());
        Communication instance = injector.getInstance(Communication.class);
        instance.sendMessage("do do do do do do do");
    }
}