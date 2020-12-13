package com.ukyu.base.concurrent;

import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author ukyu
 * @date 2020/12/4
 **/
public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(1000);
        System.out.println("Hello World!!");
//        Thread.currentThread().setPriority();
        Thread.yield();



    }
}
