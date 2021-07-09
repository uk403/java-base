package com.ukyu.thread.thread_again.concurrent_again.executor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程数调优
 * @author ukyu
 * @since 2021-7-9
 */
public class CoreSizeTuning {
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(512));
        for(int i = 0; i < 1000; i++){
            executor.execute(new MyTask(i));
        }

    }
}

@Slf4j
class MyTask implements Runnable{
    int value;
    public MyTask(int value){
        this.value = value;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int i = value; i < 100; i++) {
            sum+= i;
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException ignored) {

        }
        log.info(Thread.currentThread()  + " "+ sum);
    }
}
