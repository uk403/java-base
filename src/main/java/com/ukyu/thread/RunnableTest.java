package com.ukyu.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ukyu
 * @date 2020/7/31
 **/
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new MyRunnable()).start();
        new Thread(new MyRunnable()).start();
    }
}

class MyRunnable implements Runnable {

    private static int total = 0;
    private ReentrantLock lock = new ReentrantLock();
    int index = 3;
    @Override
    public void run() {


    }

    void income(){
        lock.lock();
        try {
            Thread.sleep(100);
            total+=1000;
            System.out.println(Thread.currentThread().getName() + "余额" + total);

        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }


    }

}
