package com.ukyu.thread.thread_again.concurrent_again.executor;

/**
 * 监视器Service
 * @author ukyu
 */
public interface ExecutorServiceMonitorMXBean {
    double getRequestPerSecondRetirementRate();

    double getAverageServiceTime();

    double getAverageTimeWaitingInPool();

    double getAverageResponseTime();

    double getEstimatedAverageNumberOfActiveRequests();

    double getRatioOfDeadTimeToResponseTime();

    double v();
}
