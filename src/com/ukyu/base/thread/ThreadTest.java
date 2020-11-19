package com.ukyu.base.thread;

/**
 * @author ukyu
 * @date 2020/7/31
 **/

public class ThreadTest extends Thread{
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

    }
}

class MyThread extends Thread{

    @Override
    public void run() {
        super.run();
        int index = 100;
        for(int i=0;i<index;i++) {
            if(i%2==0)
            {
                System.out.println(i);
            }
        }
    }
}
