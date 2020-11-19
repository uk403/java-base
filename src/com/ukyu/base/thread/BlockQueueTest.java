package com.ukyu.base.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ukyu
 * @date 2020/10/18
 **/
public class BlockQueueTest {
    public static void main(String[] args) {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        Runnable r1 = () -> {
            int i = 0;
            while(true){
                try {
                    System.out.println("我在生产 -" + i++);
                    queue.put(i+"");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable r2 = () -> {
            try{
                while(true) {
                    System.out.println("我在消耗-" + queue.take());
                    Thread.sleep(3000);
                }
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

    }
}
