package com.ukyu.thread.thread_again.concurrent_again;

import java.util.concurrent.ThreadLocalRandom;

/**
 * ThreadLocalRandom的使用
 * @author ukyu
 * @date 2021/3/10
 **/
//@Log4j
public class ThreadLocalRandomDemo {
    public static void main(String[] args) {
        // 跟ThreadLocal的实现原理差不多,每个线程都维护一个种子变量
//        这样就不会造成种子变量的竞争,大大提高并发性能
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 5; i++) {
//            log.info(random.nextInt(5));
        }

    }
}
