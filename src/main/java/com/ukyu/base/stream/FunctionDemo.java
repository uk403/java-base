package com.ukyu.base.stream;

import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

/**
 * 几个常见的函数接口
 * @author ukyu
 * @time 2021/2/25 23:13
 */
@Log4j
public class FunctionDemo {
    public static void main(String[] args) {
////  Function    ----      apply
//        Function<Integer, Integer> func = a -> a * 2;
        // 之后
//        func = func.andThen(a -> 3 * a);
//        Function<Integer, Integer> f = a -> a * 3;

//        int x = 5;
//        MyFunction mf = new MyFunction() {
//            @Override
//            public int add(int a, int b) {
//
//                return a + b;
//            }
//        };

//
////        之前，先处理compose里的action
//        func = func.compose(a -> 5 * a);
//
//        log.info(func.apply(3));
//
//        Function<String, String> f1 = Function.identity();
//        log.info(f1);

//  ------      Predicate
//        Integer x = 3;
//        IntPredicate 可以代替下面的 Predicate<Integer>
//        Predicate<Integer> predicate = i -> i > 3;
//
//        log.info(predicate.test(3));

////   ----     Consumer
        Consumer<List<Integer>> consumer = a ->
                a.forEach(i -> System.out.print(i + " "));
//
////    ---------    Supplier
        List<Integer> list = new ArrayList<>(8);
        Supplier<List<Integer>> s = () -> {
            for(int i = 0; i< 8; i++)
            {
                list.add(i);
            }
            return list;
        };
        consumer.accept(s.get());

//        更多的函数式接口都在java.util.function，其余都是基于这四个而来的

    }
}

//@FunctionalInterface 或单个
//interface MyFunction{
//    int add(int a, int b);
//}
