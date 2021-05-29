package com.ukyu.thread.thread_again.concurrent_again.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS
 * @author ukyu
 * @date 2021/3/12
 **/
public class AQSDemo {

    private static Semaphore se = new Semaphore(0);

    public static void main(String[] args) {
//        Lock lock = new ReentrantLock();
//        Condition condition = lock.newCondition();
//
//        new Thread(() -> {
////            lock.lock();
//            try {
//                se.acquireUninterruptibly();
//                System.out.println("T2运行");
//            } finally {
//                se.release();
//        }
//        }).start();
//
//        new Thread(() -> {
////            lock.lock();
//            try {
//                se.acquireUninterruptibly();
//                System.out.println("T1运行");
//            } finally {
////                lock.unlock();
////                se.release();
//            }
//        }).start();

//        while (true) {
//            System.out.println("hi");
//            LockSupport.park(Thread.currentThread());
//
//        }

      Lock lock = new ReentrantLock();
      ExecutorService executorService = Executors.newFixedThreadPool(3);


    }
}

class TestSemaphore {

    private static Semaphore sem = new Semaphore(0);

    private static class Thread1 extends Thread {
        @Override
        public void run() {
            sem.acquireUninterruptibly();
        }
    }

    private static class Thread2 extends Thread {
        @Override
        public void run() {
            sem.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000000; i++) {
            Thread t1 = new Thread1();
            Thread t2 = new Thread1();
            Thread t3 = new Thread2();
            Thread t4 = new Thread2();
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            System.out.println(i);
        }
    }
}
