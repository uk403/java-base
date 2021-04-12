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
                try{
                    for (int j = 0; j < 10; j++) {
                        if (i.get() != 0) {
                            aCondition.await();
                        }
                        System.out.println("A");
                        i.set(1);
                        bCondition.signal();
                    }
                }catch (InterruptedException ex){

                }
                finally {
                    lock.unlock();
                }
        }).start();

        new Thread(() ->{
            lock.lock();
            try{
                for (int j = 0; j < 10; j++) {
                    if (i.get() != 1) {
                        bCondition.await();
                    }
                    System.out.println("B");
                    i.set(0);
                    aCondition.signal();
                }
            }catch (InterruptedException ex){

            }
            finally {
                lock.unlock();
            }
        }).start();
    }
}
