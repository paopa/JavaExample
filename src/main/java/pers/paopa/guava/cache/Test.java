package pers.paopa.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache cache = new Cache().getCache();
        System.out.println("Invocation #1");
        System.out.println(cache.get("100"));
        System.out.println(cache.get("103"));
        System.out.println(cache.get("110"));
        System.out.println("Invocation #2");
        System.out.println(cache.get("110"));
        System.out.println(cache.get("100"));
        System.out.println(cache.get("103"));
    }
}

@Getter
class Cache {
    LoadingCache cache;

    Cache() {
        this.cache = CacheBuilder.newBuilder()
                .maximumSize(5)
                .expireAfterAccess(30, TimeUnit.MINUTES)
                .build(load());
    }

    private CacheLoader<Object, Object> load() {
        return new CacheLoader<>() {
            @Override
            public Object load(Object key) {
                return new MockData().loadData(key);
            }
        };
    }

}

class MockData {
    private final Map map = Map.ofEntries(
            Map.entry("100", new Data("Mahesh", "Finance", "100")),
            Map.entry("103", new Data("Rohan", "IT", "103")),
            Map.entry("110", new Data("Sohan", "Admin", "114"))
    );

    public Object loadData(Object key) {
        System.out.println("Data hit for " + key);
        return this.map.get(key);
    }
}

@lombok.Data
class Data {
    private final String name;
    private final String dept;
    private final String id;
}
