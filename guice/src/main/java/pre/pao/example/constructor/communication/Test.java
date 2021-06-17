package pre.pao.example.constructor.communication;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.name.Named;
import com.google.inject.name.Names;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

public class Test
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new Module());
        injector.getInstance(Communication.class).sendMessage("hello!~@#$ff");
    }
}

final class Module
        extends AbstractModule
{
    @Override
    protected void configure()
    {
        bind(Communicator.class)
//                .annotatedWith(Names.named("c1"))
                .to(Communicator.Default.class)
                .in(Scopes.SINGLETON);
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

//@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor_ = {@Inject})
@RequiredArgsConstructor(onConstructor_ = {@Inject})
final class Communication
        implements Communicator
{

    private final Communicator communicator;

//    @Inject
//    public Communication(Communicator communicator)
//    {
//        this.communicator = communicator;
//    }

    @Override
    public boolean sendMessage(String message)
    {
        return communicator.sendMessage(message);
    }
}
