package com.ukyu.thread.thread_again.concurrent_again.lock;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 * @author ukyu
 * @date 4/16/2021
 **/
public class RWLockDemo {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    public String get(String key) {
        r.lock();
        try { return m.get(key); }
        finally { r.unlock(); }
    }
    public String[] allKeys() {
        r.lock();
        try { return  m.keySet().toArray(new String[0]); }
        finally { r.unlock(); }
    }
    public String put(String key, String value) {
        w.lock();
        try { return m.put(key, value); }
        finally { w.unlock(); }
    }
    public void clear() {
        w.lock();
        try { m.clear(); }
        finally { w.unlock(); }
    }

    public static void main(String[] args) {
        int a = 5;
        final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
        final Lock readLock = lock.readLock();
        final Lock writeLock = lock.writeLock();
        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println(a);
                try {
                    Thread.sleep(5000);

            }catch (InterruptedException e) {
                }
            }finally {
                readLock.unlock();
            }
        }).start();

        new Thread(() -> {
            readLock.lock();
            try {
                System.out.println(a);
            }finally {
                readLock.unlock();
            }
        }).start();
    }
}