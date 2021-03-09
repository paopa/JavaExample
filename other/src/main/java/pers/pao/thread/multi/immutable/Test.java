package pers.pao.thread.multi.immutable;


import lombok.Data;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 還是需要依照需求 在建立 immutable object
 */
public class Test {
    public static void main(String[] args) {
        demo();
    }

    private static void demo() {
        ExecutorService es = Executors.newFixedThreadPool(5);
        int i = 0;
        while (i < 5) {
            es.execute(new SimpleThreadExample(new User("user-" + i, "aaa")));
            i++;
        }
        es.shutdown();
    }
}

@Data
class User {
    private final String name;
    private final String password;
}

class SimpleThreadExample implements Runnable {

    private User user;

    public SimpleThreadExample(User user) {
        this.user = user;
    }

    @Override
    public void run() {
        System.out.println(this.user.getName() + " " + this.user.getPassword());
    }

}