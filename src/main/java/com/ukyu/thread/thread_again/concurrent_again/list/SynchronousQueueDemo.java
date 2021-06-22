package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.concurrent.SynchronousQueue;

/**
 * SynchronousQueue
 * @author ukyu
 * @time 2021/6/15 22:36
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> sync = new SynchronousQueue<>();

//        new Thread(() -> {
//            try {
//                sync.put("hello");
//                sync.put("world");
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(() -> {
//            System.out.println(sync.poll());
//            System.out.println(sync.poll());
//        }).start();

//        new Thread(() -> {
//            System.out.println(sync.poll());
//        }).start();

    }
}
