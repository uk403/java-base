package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>();
        queue.offer(5);
        queue.offer(1);
        queue.offer(2);
        queue.offer(0);
        System.out.println(queue);

//        AtomicInteger count = new AtomicInteger(0);
//        Thread t1 = new Thread(() ->{
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException ignored) {
//
//            }
//            System.out.println("yield 前");
//            if (count.get() != 0){
//                Thread.yield();
//            }
//            System.out.println("yield 后");
//        });
//
//        Thread t2 = new Thread(() ->{
//            System.out.println("count + 1");
//            count.getAndIncrement();
//        });
//
//        Thread t3 = new Thread(() ->{
//            System.out.println("count - 1");
//            count.getAndDecrement();
//        });
//
//        t1.start();
//        t2.start();
//        Thread.sleep(1000);
//        t3.start();
    }
}
