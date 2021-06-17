package pre.pao.example.aop.message.logger;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Scopes;
import com.google.inject.matcher.Matchers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Arrays;

public final class Test
{
    public static void main(String[] args)
    {
        Injector injector = Guice.createInjector(new Module(), new AOPModule());
        injector.getInstance(Communication.class).sendMessage("hello!@@@!@#");
    }
}

final class Module
        extends AbstractModule
{

    @Override
    protected void configure()
    {
        bind(Communicator.class).to(Communicator.Default.class).in(Scopes.SINGLETON);
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
            log.info("sending message --t:{}", message);
            return false;
        }
    }
}

@RequiredArgsConstructor(onConstructor_ = {@Inject})
class Communication
        implements Communicator
{

    private final Communicator communicator;

    @MessageSentLoggable
    @Override
    public boolean sendMessage(String message)
    {
        return communicator.sendMessage(message);
    }
}

final class AOPModule
        extends AbstractModule
{

    @Override
    protected void configure()
    {
        bindInterceptor(
                Matchers.any(),
                Matchers.annotatedWith(MessageSentLoggable.class),
                new MessageLogger()
        );
    }
}

@Slf4j
final class MessageLogger
        implements MethodInterceptor
{

    @Override
    public Object invoke(MethodInvocation invocation)
            throws Throwable
    {
        Object proceed = invocation.proceed();
        Arrays.stream(invocation.getArguments())
                .forEach(arg -> log.info(arg.toString()));
        return proceed;
    }
}

@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.METHOD)
@interface MessageSentLoggable
{

}
