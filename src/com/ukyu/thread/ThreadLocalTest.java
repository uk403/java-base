package com.ukyu.thread;

/**
 * @author ukyu
 * @date 2020/10/18
 **/
public class ThreadLocalTest{
    public static void main(String[] args) {
        Test t1 = new Test("t1");
        Test t2 = new Test("t2");
        Test t3 = new Test("t3");
        t1.start();
        t2.start();
        t3.start();
    }
}

