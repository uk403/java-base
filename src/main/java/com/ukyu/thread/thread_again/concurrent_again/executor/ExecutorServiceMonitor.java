package com.ukyu.thread.thread_again.concurrent_again.executor;

import org.springframework.context.annotation.EnableMBeanExport;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池监视器
 * @author ukyu
 */

public class ExecutorServiceMonitor implements ExecutorServiceMonitorMXBean {
    private InstrumentedThreadPoolExecutor executor;

    public ExecutorServiceMonitor(InstrumentedThreadPoolExecutor executor){
        this.executor = executor;
    }
    long fromNanoToSeconds(long nanos) {
        return TimeUnit.NANOSECONDS.toSeconds(nanos);
    }

    @Override
    public double getRequestPerSecondRetirementRate() {
        return (double) this.executor.getNumberOfRequestsRetired()
                / fromNanoToSeconds(executor.getAggregateInterRequestArrivalTime());
    }

    @Override
    public double getAverageServiceTime() {
        return fromNanoToSeconds(executor.getTotalServiceTime())
                / (double) this.executor.getNumberOfRequestsRetired();
    }

    @Override
    public double getAverageTimeWaitingInPool() {
        return fromNanoToSeconds(this.executor.getTotalPoolTime())
                / (double) this.executor.getNumberOfRequestsRetired();
    }

    @Override
    public double getAverageResponseTime() {
        return this.getAverageServiceTime() + this.getAverageTimeWaitingInPool();
    }

    /**
     * 请求数
     */
    @Override
    public double getEstimatedAverageNumberOfActiveRequests() {
        return getRequestPerSecondRetirementRate() * (getAverageServiceTime() + getAverageTimeWaitingInPool());
    }

    @Override
    public double getRatioOfDeadTimeToResponseTime() {
        double poolTime = (double) this.executor.getTotalPoolTime();
        return poolTime / (poolTime + (double) executor.getTotalServiceTime());
    }

    @Override
    public double v() {
        return getEstimatedAverageNumberOfActiveRequests() / (double) Runtime.getRuntime().availableProcessors();
    }
}
