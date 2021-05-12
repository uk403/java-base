package com.ukyu.thread.thread_again.concurrent_again;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore信号量Demo
 * @author ukyu
 * @date 5/12/2021
 **/
public class SemaphoreDemo {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(() -> {
            System.out.println(Thread.currentThread() + "start");
            semaphore.release();
        });

        executor.submit(() -> {
            System.out.println(Thread.currentThread() + "start");
            semaphore.release();
        });

        System.out.println(Thread.currentThread() + "等待两个子线程执行");
        semaphore.acquire(2);
        System.out.println("两个子线程执行完毕");
        executor.shutdown();
    }
}

