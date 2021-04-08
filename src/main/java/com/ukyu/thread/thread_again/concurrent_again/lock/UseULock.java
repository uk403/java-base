package com.ukyu.thread.thread_again.concurrent_again.lock;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;

/**
 * 使用自定义的ULock锁
 * @author ukyu
 * @date 4/8/2021
 **/
public class UseULock {
    public static void main(String[] args) {
        ULock lock = new ULock();
        Condition aCondition = lock.newCondition();
        Condition bCondition = lock.newCondition();
        AtomicInteger i = new AtomicInteger();
        new Thread(() ->{
            lock.lock();
            try {
                while (i.get() == 1) {
                    aCondition.wait();
                }
                System.out.println("A");
                i.set(1);
                bCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();

        new Thread(() ->{
            lock.lock();
            try {
                while (i.get() == 0) {
                    bCondition.wait();
                }
                System.out.println("B");
                i.set(0);
                aCondition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }).start();
    }
}
