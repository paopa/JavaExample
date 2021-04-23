package pers.pao.stream.reactive;

import com.google.common.base.Throwables;
import lombok.SneakyThrows;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

class EndSubscriber<T> implements Flow.Subscriber<T> {

    private Flow.Subscription subscription;
    public List<T> consumedElements = new LinkedList<>();
    private final CountDownLatch latch;

    public EndSubscriber(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(1);
    }

    @SneakyThrows
    @Override
    public void onNext(T item) {
        Thread.sleep(1000);
        System.out.println("Got: " + item);
        latch.countDown();
        subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(Throwables.getStackTraceAsString(throwable));
    }

    @Override
    public void onComplete() {
        System.out.println("Done");

    }
}

public class Test {

    @org.junit.jupiter.api.Test
    public void test() throws Exception{

        CountDownLatch latch = new CountDownLatch(6);

        // given
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        EndSubscriber<String> endSubscriber = new EndSubscriber<>(latch);
        publisher.subscribe(endSubscriber);
        List<String> items = List.of("1", "x", "2", "x", "3", "x");

        //when
        items.forEach(publisher::submit);
        publisher.close();
        latch.await();

    }
}
