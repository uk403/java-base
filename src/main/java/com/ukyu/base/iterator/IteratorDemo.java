package com.ukyu.base.iterator;

import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 迭代器的demo
 * @author ukyu
 * @date 2021/1/13
 **/
//@Slf4j
public class IteratorDemo {
    public static void main(String[] args) {
//        某个列表implements Iterable 表明该类能产生迭代器
        AtomicInteger index = new AtomicInteger();
        List<StringBuilder> list = Stream.generate(() -> new StringBuilder("hello world!" + index.getAndIncrement()))
                .limit(1000)
                .collect(Collectors.toList());
//        StringBuilder sb;
//        System.out.println(list.size());
//        Iterator<StringBuilder> iterator = list.iterator();

        Spliterator<StringBuilder> s1 = list.spliterator();
//        分成几份，互相不影响 trySplit()
        Spliterator<StringBuilder> s2 = s1.trySplit();
        System.out.println(s2.estimateSize() + " " + s1.estimateSize());
//        一个一个处理该集合中的元素
//        s1.tryAdvance(System.out::println)

//        ExecutorService es = Executors.newFixedThreadPool(10);
//        es.execute(() -> {
//            while(s1.tryAdvance(System.out::println))
//            {
//                System.out.println(Thread.currentThread().getName());
//                //                    Thread.sleep(50);
//            };
//        });
//
//        es.execute(() -> {
//            while (s2.tryAdvance(System.out::println)) {
//                System.out.println(Thread.currentThread().getName());
//                //                    Thread.sleep(50);
//            }
//        });
//        es.shutdown();

//        log.info(String.valueOf(ForkJoinPool.getCommonPoolParallelism()));

        s1.hasCharacteristics(Spliterator.CONCURRENT);
    }
}


