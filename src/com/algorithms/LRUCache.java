package com.algorithms;

import java.util.*;

public class LRUCache<K, V> {
    private int capacity;
    private Map<K, V> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    public V get(Integer key) {
        return cache.getOrDefault(key, null);
    }

    public void set(K key, V value) {
        if (cache.size() >= capacity) {
            Iterator<K> iterator = cache.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.set(1,2);
        cache.set(2,3); //[1,2][2,3]
        cache.set(1, 5);//[2,3][1,5]
        System.out.println(cache.get(1)); //5
        cache.set(4,5); //[1,5][4,5]
        cache.set(6,7);//[4,5][6,7]
        System.out.println(cache.get(4)); //5
        cache.set(1,2); //[4,5][1,2]
        System.out.println(cache.get(3)); //null
        System.out.println(cache.get(4)); //5
        System.out.println(cache.get(1)); //2
    }
}
