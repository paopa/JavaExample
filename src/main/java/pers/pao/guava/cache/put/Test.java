package pers.pao.guava.cache.put;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Getter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws ExecutionException {
        LoadingCache<Long, ConcurrentHashMap<Integer, Boolean>> cache = new Cache().getCache();
        cache.get(123L).putIfAbsent(456, true);
        System.out.println(cache.get(123L));
        cache.get(123L).putIfAbsent(789, false);
        System.out.println(cache.get(123L));
        System.out.println(cache.get(567L));
    }
}

@Getter
class Cache {
    LoadingCache<Long, ConcurrentHashMap<Integer, Boolean>> cache;

    Cache() {
        this.cache = initCache();
    }

    private LoadingCache<Long, ConcurrentHashMap<Integer, Boolean>> initCache() {
        CacheLoader<Long, ConcurrentHashMap<Integer, Boolean>> loader = new CacheLoader<>() {
            @Override
            public ConcurrentHashMap<Integer, Boolean> load(Long key) {
                return new ConcurrentHashMap<>();
            }
        };
        return this.cache = CacheBuilder.newBuilder()
                .maximumSize(5)
                .expireAfterAccess(30, TimeUnit.MINUTES)
                .build(loader);
    }

}