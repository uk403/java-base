package com.ukyu.base.iterator;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 迭代器的demo
 * @author ukyu
 * @date 2021/1/13
 **/
public class IteratorDemo {
    public static void main(String[] args) {
//        某个列表implements Iterable 表明该类能产生迭代器
        AtomicInteger index = new AtomicInteger();
        List<StringBuilder> list = Stream.generate(() -> new StringBuilder("hello world!" + index.getAndIncrement()))
                .limit(999)
                .collect(Collectors.toList());
//        for (String s : list) {
//            System.out.println(s);
//        }
//        foreach -> 迭代器的方式
//        列表调用其迭代器
//        数组调用自身的循环

//        查看调用的集合是否支持该操作
//        ListIterator<String> it01 = list.listIterator();
//        it01.add("01");
//        System.out.println(list.toString());


        Spliterator<StringBuilder> s1 = list.spliterator();
//        分成几份，互相不影响 trySplit()
        Spliterator<StringBuilder> s2 = s1.trySplit();
        System.out.println(s2.estimateSize() + " " + s1.estimateSize());
//        一个一个处理该集合中的元素
//        s1.tryAdvance(System.out::println)

        int current = 0;
        ExecutorService es = Executors.newFixedThreadPool(10);
//        es.execute(() -> {
//            while(s1.tryAdvance(System.out::println))
//            {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            };
//        });
//
//        es.execute(() -> {
//            while (s2.tryAdvance(System.out::println)) {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        es.shutdown();

        s1.hasCharacteristics(Spliterator.CONCURRENT);
    }
}


