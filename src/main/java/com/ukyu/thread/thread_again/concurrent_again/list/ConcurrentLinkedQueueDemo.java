package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * ConcurrentLinkedQueue是一个非阻塞(CAS)队列,FIFO,是线程安全的，对于出队、入队是线程安全的，其他的一些操作，比如size(),可能会不准
 * @author ukyu
 * @time 2021/4/26 22:29
 */
public class ConcurrentLinkedQueueDemo {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.remove("C");
    }
}
