package com.ukyu.thread.thread_again.concurrent_again.list;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author ukyu
 * @date 2021/06/08
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.add("test");
    }
}
