package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayBlockingQueue debug
 * @author ukyu
 * @date 4/29/2021
 **/
public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> array = new ArrayBlockingQueue<>(3);
        array.offer("A");
        array.offer("B");
        array.offer("C");
        array.poll();
        array.offer("D");
        System.out.println(array);

    }
}
