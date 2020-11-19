package com.ukyu.base.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ukyu
 * @date 2020/8/3
 **/
public class PoolTest {
    public static void main(String[] args) {
//        ExecutorService service = Executors.newFixedThreadPool(10);
//        service.execute(new Pool());
//        service.shutdown();

//        TimeUnit unit;
//        BlockingQueue workQueue;
        List<Integer> list = new LinkedList<>();
        final Random random = new Random();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(100, 100, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
        for(int i=0;i<2000;i++) {
            executor.execute(()->
                    list.add(random.nextInt())
            );
        }
        executor.shutdown();
        System.out.println(list.size());

    }

}
class Pool implements Runnable{

    @Override
    public void run() {
        for(int i=0;i<100;i++)
        {
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }
}
