package com.ukyu.algorithm;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 自定义Map，保证线程安全
 * @author ukyu
 * @time 2021/7/17 13:01
 */
public class MyMap<K, V> {
    private final Node<K, V>[] table;

    private int size;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static class Node<K,V>{
        private final int hash;
        private final K key;
        private V value;
        private Node<K,V> next;

        Node(int hash, K key, V val, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = val;
            this.next = next;
        }
    }

    @SuppressWarnings("unchecked")
    public MyMap(int capacity){
        // 初始化
        table = new Node[tableSizeFor(capacity)];
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    static int hash(Object key) {
        int h;
        // 保证只有一个null
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * 插入值；时间复杂度O(1),最坏的情况是O(n);
     * @param key 键
     * @param value 值
     * @return 返回原有的值
     */
    public V put(K key, V value){
        return putVal(hash(key), key, value);
    }

    private V putVal(int hash, K key, V value) {
        writeLock.lock();
        try {
            Node<K, V> p;
            int index;
            int length = table.length;
            if ((p = table[index = (length - 1) & hash]) == null) {
                table[index] = new Node<>(hash, key, value, null);
            } else {
                // 当前的key
                K k;
                Node<K, V> e;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k)))) {
                    e = p;
                } else {
                    for(;;) {
                        if ((e = p.next) == null) {
                            p.next = new Node<>(hash, key, value, null);
                            break;
                        }
                        // 下标为(length - 1) & hash已经有值了
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k)))) {
                            break;
                        }
                        p = e;
                    }
                }
                if (e != null) {
                    V oldVal = e.value;
                    e.value = value;
                    return oldVal;
                }
            }
            size++;
            return null;
        }finally {
            writeLock.unlock();
        }
    }

    /**
     * 根据key获取值；时间复杂度O(1),最坏是O(n);
     * @param key 建
     * @return 返回值
     */
    public V get(K key){
        return getValue(hash(key), key);
    }

    private V getValue(int hash, K key) {
        Node<K, V>[] tab;
        Node<K, V> first, e;
        int length;
        K k;
        readLock.lock();
        try {
            if ((tab = table) != null && (length = tab.length) > 0 &&
                    (first = tab[(length - 1) & hash]) != null) {
                if (first.hash == hash &&
                        // key的类型是任意的
                        ((k = first.key) == key || (key != null && key.equals(k)))) {
                    return first.value;
                }
                if ((e = first.next) != null) {
                    do {
                        if (e.hash == hash &&
                                ((k = e.key) == key || (key != null && key.equals(k)))) {
                            return e.value;
                        }
                    } while ((e = e.next) != null);
                }
            }
            return null;
        }finally {
            readLock.unlock();
        }
    }

    /**
     * 根据key删除值; 时间复杂度O(1),最坏是O(n)
     * @param key 想要删除的值
     * @return 原有的值
     */
    public V remove(K key){
        Node<K, V> p;
        writeLock.lock();
        try {
            int hash = hash(key);
            int length;
            int index;
            if (table != null && (length = table.length) > 0 &&
                    (p = table[index = (length - 1) & hash]) != null) {
                // 临时Key
                K k;
                Node<K, V> q;
                if (p.hash == hash &&
                        ((k = p.key) == key || (key != null && key.equals(k)))) {
                    // 头结点就是要删除的元素
                    table[index] = table[index].next;
                    size--;
                    return p.value;
                } else if ((p = (q = p).next) != null) {
                    do {
                        if (p.hash == hash &&
                                ((k = p.key) == key || (key != null && key.equals(k)))) {

                            q.next = p.next;
                            size--;
                            return p.value;
                        }
                    } while ((p = (q = p).next) != null);
                }

            }
            return null;
        }
        finally {
            writeLock.unlock();
        }
    }

    /**
     * 返回所有元素的个数 O(1)
     * @return 元素个数
     */
    public int size(){
        readLock.lock();
        try {
            return size;
        }finally {
            readLock.unlock();
        }
    }
}
