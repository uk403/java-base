package com.ukyu.thread.thread_again;

/**
 * 原子性： 要么发生，要么不发生，不会中途停止
 * volatile，可以让属性在线程间具有可见性，即看见属性的最新变化
 * @author ukyu
 * @date 2021/3/4
 **/
public class AtomicDemo {

//    竞争资源带来的一些问题：------
//    死锁：
//  Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.

//  饥饿： 一个线程长时间占用锁，而另一个线程需要这个锁，但是一直没有获取到，一直处于阻塞

//  活锁： 两个线程互相响应对方的行为；在一个很窄的过道，A向左走，B向右走，A往右让B，B往左让A，A、B依旧阻塞对方


}
