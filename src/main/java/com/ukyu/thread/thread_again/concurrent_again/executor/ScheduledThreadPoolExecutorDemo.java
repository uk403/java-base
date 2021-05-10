package com.ukyu.thread.thread_again.concurrent_again.executor;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPoolExecutor
 * @author ukyu
 * @date 5/10/2021
 **/
public class ScheduledThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
        executor.schedule(() -> System.out.println("Hello"),
                 3, TimeUnit.SECONDS);

    }
}
