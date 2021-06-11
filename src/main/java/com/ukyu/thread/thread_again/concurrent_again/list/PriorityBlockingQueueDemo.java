package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<>();

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

        int oldCap = Integer.MAX_VALUE;
        int minCap = oldCap - 1;
        System.out.println(minCap);
    }
}
