package com.ukyu.thread.thread_again.concurrent_again.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.*;

/**
 * 线程池的demo
 * @author ukyu
 * @date 5/7/2021
 **/
@Log4j
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory =
                new ThreadFactoryBuilder().setNameFormat("my-pool-thread-%d").build();
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS
                        , new LinkedBlockingQueue<>(), namedThreadFactory);
        executor.execute(() -> log.info("Hello"));




    }
}