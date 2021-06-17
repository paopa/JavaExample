package pre.pao.example.method;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import lombok.extern.slf4j.Slf4j;

public final class Test
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new Module());
        injector.getInstance(Communication.class).sendMessage("hello!~");
    }
}

final class Module
        extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Communication.class)
                .toInstance(new Communication());
    }

    @Provides
    @Named("DefaultCommunicator")
    public Communicator getCommunicator()
    {
        return new Communicator.Default();
    }
}

interface Communicator
{
    boolean sendMessage(String message);

    @Slf4j
    final class Default
            implements Communicator
    {
        @Override
        public boolean sendMessage(String message)
        {
            log.info("sending message:{}", message);
            return false;
        }
    }
}

final class Communication
        implements Communicator
{
    private Communicator communicator;

    @Inject
    private void setCommunicator(@Named("DefaultCommunicator")
            Communicator communicator)
    {
        this.communicator = communicator;
    }

    @Override
    public boolean sendMessage(String message)
    {
        return communicator.sendMessage(message);
    }
}
