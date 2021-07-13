package com.ukyu.thread.thread_again.concurrent_again.executor;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.management.*;
import java.lang.management.ManagementFactory;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * 调节线程池数
 * @author ukyu
 * @date 5/7/2021
 **/
@Log4j
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) throws InterruptedException, MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException {
        ThreadFactory namedThreadFactory =
                new ThreadFactoryBuilder().setNameFormat("my-pool-thread-%d").build();
        InstrumentedThreadPoolExecutor executor =
                new InstrumentedThreadPoolExecutor(5, 10, 60, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(512), namedThreadFactory);

        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("ukyu:name=monitor");
        mbs.registerMBean(new ExecutorServiceMonitor(executor), name);



        for (int w = 0; w < 1000; w++) {

            executor.execute(() -> {
                double p = 1;
                int j = 10;
                int sum = 0;
                for(double i = 1; i < 50000000; i++) { //循环相加
//                    double pCopy = p - (int)p;//最后两次的数值相减，精度位相减为0，说明精度已经达到
//                    p += Math.pow(-1,i) / ( 2 * i + 1 ); //莱布尼兹级数求和
//                    if( ( Math.abs( pCopy - ( p - (int)p ) ) * Math.pow(10,j) ) <= 0) {
//                        break;//公式实现精度后退出循环
//                    }
                    sum += i;
                }
                log.info("sum: " + sum);
            });

        }

        while (true){
            log.info(executor.getPoolSize());
        }

    }
}

//@Slf4j
//class MonitorRunnable implements Runnable{
//    private ExecutorServiceMonitor monitor;
//
//    public MonitorRunnable(InstrumentedThreadPoolExecutor executor){
//        monitor = new ExecutorServiceMonitor(executor);
//    }
//    @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(2000);
//                log.info("请求数: " + monitor.());
//            } catch (InterruptedException e) {
//
//            }
//        }
//    }
//}
