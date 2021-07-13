package com.ukyu.thread.thread_again.concurrent_again.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.log4j.Log4j;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 调节线程池数
 * @author ukyu
 * @date 5/7/2021
 **/
@Log4j
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        ThreadFactory namedThreadFactory =
                new ThreadFactoryBuilder().setNameFormat("my-pool-thread-%d").build();
        InstrumentedThreadPoolExecutor executor =
                new InstrumentedThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(), namedThreadFactory);




    }
}

class MonitorRunnable implements Runnable{
    private ExecutorServiceMonitor monitor = new ExecutorServiceMonitor();
    @Override
    public void run() {
        monitor.
    }
}
