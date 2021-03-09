package com.ukyu.thread.thread_again.concurrent_again;

/**
 * 线程副本
 * @author ukyu
 * @date 2021/3/8
 **/
public class ThreadLocalDemo {
    static ThreadLocal<String> tLocal = new ThreadLocal<>();
    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            tLocal.set("t1");
            System.out.println(Thread.currentThread().getName() + ":" + tLocal.get());
        });
        t1.setName("Thread1");

        Thread t2 = new Thread(() ->{
            tLocal.set("t2");
            System.out.println(Thread.currentThread().getName() + ":" + tLocal.get());
        });
        t2.setName("Thread2");

        t1.start();
        t2.start();

    }
}
