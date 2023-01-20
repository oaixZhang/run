package me.xiaoz.classic;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>(2);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        int value = cache.remove(key);
        cache.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        } else {
            if (cache.size() >= capacity) {
                int firstKey = cache.keySet().iterator().next();
                cache.remove(firstKey);
            }
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(2, 6);
        lruCache.put(1, 5);
        lruCache.put(1, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }
}
