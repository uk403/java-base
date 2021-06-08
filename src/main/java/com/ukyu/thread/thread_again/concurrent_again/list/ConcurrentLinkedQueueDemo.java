package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConcurrentLinkedQueue是一个非阻塞(CAS)队列,FIFO,是线程安全的，对于出队、入队是线程安全的，其他的一些操作，比如size(),可能会不准
 * @author ukyu
 * @time 2021/4/26 22:29
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("A");
        queue.offer("B");


        AtomicInteger count = new AtomicInteger(0);
        ReentrantLock lock = new ReentrantLock();
        Condition con = lock.newCondition();
        Thread ta = new Thread(() -> {
            lock.lock();
            try {
                System.out.println("await 前");
                if (count.get() == 0) {
                    System.out.println("被阻塞");
                    con.await();
                }
                System.out.println("await后~");
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        });

        Thread tb = new Thread(() -> {
            lock.lock();
            try {
                count.getAndAdd(0);
                Thread.sleep(1000);
                con.signal();
            } catch (InterruptedException e) {

            } finally {
                lock.unlock();
            }
        });

        ta.start();

        tb.start();
    }
}
