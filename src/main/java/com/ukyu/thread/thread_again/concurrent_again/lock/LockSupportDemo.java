package com.ukyu.thread.thread_again.concurrent_again.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * 阻塞綫程的原語
 * @author ukyu
 * @date 2021/3/12
 **/
public class LockSupportDemo {
    public static void main(String[] args) {
        System.out.println("begin1 park!");
        // 使當前綫程獲取許可證
        LockSupport.unpark(Thread.currentThread());
//        當前綫程若沒有許可證，則挂起當前綫程；若有許可證則直接返回
        LockSupport.park();
        System.out.println("end1 park!");
    }
}
