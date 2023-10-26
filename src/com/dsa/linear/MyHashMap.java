package com.dsa.linear;

import java.util.LinkedList;

public class MyHashMap <K, V> {
    private static final int DEFAULT_CAPACITY = 16;

    private LinkedList<Entry<K, V>>[] buckets;

    private int size;

    public MyHashMap() {
        this(DEFAULT_CAPACITY);
    }

    public MyHashMap(int capacity) {
        buckets = new LinkedList[capacity];
        size = 0;
    }

    public LinkedList<Entry<K, V>>[] getBuckets() {
        return buckets;
    }

    public int getSize() {
        return size;
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        if (bucket == null) {
            bucket = new LinkedList<>();
            buckets[index] = bucket;
        }

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        bucket.add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        V result = null;
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                result = entry.value;
                break;
            }
        }

        return result;
    }

    public boolean containsKey(K key) {
        boolean result = false;
        int index = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[index];

        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int getBucketIndex(K key) {
        int hashcode = key.hashCode();
        return hashcode % buckets.length;
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(1, "One");
        map.put(1, "one");
        map.put(2, "Two");
        map.put(3, "Three");
        System.out.println(map.containsKey(1));
        System.out.println(map.get(1));
    }
}
