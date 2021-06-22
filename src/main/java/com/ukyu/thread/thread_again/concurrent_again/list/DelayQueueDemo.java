package com.ukyu.thread.thread_again.concurrent_again.list;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.*;
import java.util.function.Consumer;

/**
 * DelayQueue
 * @author ukyu
 * @date 5/6/2021
 **/
public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<DelayObject<Integer>> queue = new DelayQueue<>();

        ThreadFactory factory =  new ThreadFactoryBuilder().setNameFormat("my-delayTask-thread-%d").build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 10, 60,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(), factory);
        for(int i = 0; i < 10; i++)
        {
            Long delay = System.currentTimeMillis() + 1000 * i;

            DelayObject<Integer> delayObject = new DelayObject<>(delay, i * 10, x -> System.out.println(Thread.currentThread().getName() + " " + x));

            queue.offer(delayObject);
        }

        while(!queue.isEmpty()){
            executor.execute(queue.take());
        }

        executor.shutdown();

    }
}

@Data
@AllArgsConstructor
class DelayObject<T> implements Delayed, Runnable{

    private Long delay;

    private T taskParam;

    private Consumer<T> consumer;

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delay - System.currentTimeMillis(), TimeUnit.NANOSECONDS);
    }

    @Override
    @SuppressWarnings("unchecked")
    public int compareTo(Delayed o) {
        DelayObject<T> delayObject = (DelayObject<T>) o;

        return this.delay.compareTo(delayObject.delay);
    }

    @Override
    public void run() {
        consumer.accept(taskParam);
    }
}
