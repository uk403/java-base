package com.ukyu.thread;

import static java.lang.Thread.interrupted;

/**
 * @author ukyu
 * @date 2020/8/7
 **/
public class InterruptTest {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;) {
                    ;
                }
            }
        });
        threadOne.start();
        threadOne.interrupt();
//        System.out.println("isInterrupted:" +Thread.currentThread().getName()+" " + threadOne.isInterrupted());
        System.out.println("isInterrupted:" +Thread.currentThread().getName()+" " +interrupted());
        System.out.println("isInterrupted:"+Thread.currentThread().getName()+" " + interrupted());
        System.out.println("isInterrupted:" +Thread.currentThread().getName()+" " + Thread.currentThread().isInterrupted());


    }
     void test()
    {
        System.out.println("shhhh");
    }
}


