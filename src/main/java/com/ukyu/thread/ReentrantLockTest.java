package com.ukyu.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock 可重入的互斥锁
 * synchronized 也是持有的对象监视器；但是二者持有的对象监视器不同
 * ReentrantLock 与condition配合，await signal 等待/通知模型
 * @author ukyu
 * @date 2020/10/18
 **/
public class ReentrantLockTest {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) {

    }

}
