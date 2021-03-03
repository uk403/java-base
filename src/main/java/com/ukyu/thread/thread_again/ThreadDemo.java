package com.ukyu.thread.thread_again;

/**
 * java从头到脚被设计成支持并发
 *
 * 有两个重要的执行单元
 *
 * Processes are often seen as synonymous with programs or applications.
 * 进程是系统分配资源与执行的基本单位；有自己独立的内存空间
 *
 * CPU分配资源是给线程的；CPU的资源是被线程占用的
 * 线程是CPU分配资源的基本单位，创建一个线程需要更少的资源，线程是在进程内的；画一幅JVM的内存图
 * java开始于一个主线程
 *
 * 中断: 一个线程应该终止当前的事情，去干其他的事情
 *
 * @author ukyu
 * @date 2021/3/2
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        Thread.currentThread()
    }
}
