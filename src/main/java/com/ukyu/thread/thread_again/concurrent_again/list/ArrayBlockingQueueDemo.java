package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue debug
 * @author ukyu
 * @date 4/29/2021
 **/
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> array = new ArrayBlockingQueue<>(3);
        array.offer(1);
        array.offer(2);
        array.offer(3);
//        array.poll();
//        array.offer(4);
        System.out.println(array);
    }
}
