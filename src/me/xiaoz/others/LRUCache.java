package me.xiaoz.others;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    LinkedHashMap<Integer, Integer> cache;
    int capacity;

    public LRUCache(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        updateUsed(key);
        return cache.get(key);
    }

    private void updateUsed(int key) {
        int value = cache.remove(key);
        cache.put(key, value);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value);
            updateUsed(key);
        } else {
            if (cache.size() >= capacity) {
                int first = cache.keySet().iterator().next();
                cache.remove(first);
            }
            cache.put(key, value);
        }
    }
}
