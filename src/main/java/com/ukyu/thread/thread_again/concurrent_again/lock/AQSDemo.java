package com.ukyu.thread.thread_again.concurrent_again.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS
 * @author ukyu
 * @date 2021/3/12
 **/
public class AQSDemo {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
        try{
            System.out.println("begin await");
            condition.await();
            System.out.println("end await");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        }).start();

        new Thread(() -> {
            lock.lock();
            try{
                System.out.println("begin signal");
                Thread.sleep(1000);
                condition.signal();
                System.out.println("end signal");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }
}
