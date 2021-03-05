package com.ukyu.thread.thread_again.concurrent_again;

import java.util.concurrent.locks.*;

/**
 * Lock
 * 比起隐式锁在同步代码中，其最大的优点就是可以尝试获取锁(tryLock)
 * @author ukyu
 * @date 2021/3/5
 **/
public class LockDemo {
    ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    Lock r = rwl.readLock();
    Lock w = rwl.writeLock();


}
