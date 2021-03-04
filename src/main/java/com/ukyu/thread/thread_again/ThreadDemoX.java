package com.ukyu.thread.thread_again;

/**
 * @author ukyu
 * @time 2021/3/3 22:27
 */
public class ThreadDemoX {
    public static void main(String[] args) throws InterruptedException {
//        1. interrupt
//        会清除中断标志(interrupt flag)
//        Thread.interrupted()

//        非静态方法,不会清除
//        Thread.currentThread().isInterrupted()

//        InterruptedException被抛出时，中断标志也会被清除

//        2. join, 谁调用这个方法，其他线程就要等待该线程执行完毕后才能执行
//        Thread t1 = new Thread(() ->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(i);
//            }
//        });
//        t1.start();
//        t1.join();
//        System.out.println("我要在最后打印~");


    }
}
