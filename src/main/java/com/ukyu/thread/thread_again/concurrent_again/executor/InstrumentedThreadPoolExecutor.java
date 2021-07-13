package com.ukyu.thread.thread_again.concurrent_again.executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程数调优
 * Little's law; L = rw =>线程数 = 到达率 * 平均服务时间
 * @author ukyu
 * @since 2021-7-9
 */
public class InstrumentedThreadPoolExecutor extends ThreadPoolExecutor {


    // Keep track of all of the request times
    // 每个线程请求的时间
    private final ConcurrentHashMap<Runnable, Long> timeOfRequest =
            new ConcurrentHashMap<>();
    // 每个线程开始的时间
    private final ThreadLocal<Long> startTime = new ThreadLocal<>();
    // 最后一次到达时间
    private long lastArrivalTime;
    // 总的服务时间
    private final AtomicLong totalServiceTime = new AtomicLong();
    // 总的还未执行任务的时间
    private final AtomicLong totalPoolTime = new AtomicLong();
    // 每个请求达到时间的总和
    private final AtomicLong aggregateInterRequestArrivalTime = new AtomicLong();
    // 执行完毕的次数
    private final AtomicInteger numberOfRequestsRetired = new AtomicInteger();
    // 请求次数(执行次数)
    private final AtomicInteger numberOfRequests = new AtomicInteger();

    public InstrumentedThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    // other variables are AtomicLongs and AtomicIntegers

    @Override
    protected void beforeExecute(Thread worker, Runnable task) {
        super.beforeExecute(worker, task);
        startTime.set(System.nanoTime());
    }

    @Override
    protected void afterExecute(Runnable task, Throwable t) {
        try {
            totalServiceTime.addAndGet(System.nanoTime() - startTime.get());
            totalPoolTime.addAndGet(startTime.get() - timeOfRequest.remove(task));
//            startTime.remove();
            numberOfRequestsRetired.incrementAndGet();
        } finally {
            super.afterExecute(task, t);
        }
    }

    @Override
    public void execute(Runnable task) {
        long now = System.nanoTime();

        numberOfRequests.incrementAndGet();
        synchronized (this) {
            if (lastArrivalTime != 0L) {
                aggregateInterRequestArrivalTime.addAndGet(now - lastArrivalTime);
            }
            lastArrivalTime = now;
            timeOfRequest.put(task, now);
        }
        super.execute(task);
    }

    /**
     * 返回执行完毕的次数
     */
    public int getNumberOfRequestsRetired() {
        return numberOfRequestsRetired.get();
    }

    /**
     * 每个请求达到时间的总和
     */
    public long getAggregateInterRequestArrivalTime() {
        return aggregateInterRequestArrivalTime.get();
    }

    /**
     * 总的服务时间
     */
    public long getTotalServiceTime() {
        return totalServiceTime.get();
    }

    /**
     * 在池中等待的时间的总和
     */
    public long getTotalPoolTime() {
        return totalPoolTime.get();
    }
}

