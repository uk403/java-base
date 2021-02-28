package com.ukyu.base.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * 流的探究
 * @author ukyu
 * @date 2021/2/26
 **/
public class StreamDemo {
//    An operation on a stream produces a result, but does not modify its source.
//    流分为中间操作(返回新流的操作)、终端操作
//
//    中间操作都是懒加载，不会直接执行，只有当终端操作执行才会开始执行
//    中间操作分为：
//      1. 无状态  如： filter and map, 跟之前的元素有关
//      2. 有状态  distinct and sorted

//    短路操作： 中间操作对无限的输入，返回一个有限的流时；
//              终端操作，操作无限的流在有限的时间内，这些操作就是短路操作；

//    流的副作用: 操作流的同时，还改变了其他的状态(除流之外的)
//    https://zh.wikipedia.org/wiki/%E5%89%AF%E4%BD%9C%E7%94%A8_(%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%A7%91%E5%AD%A6)
//
//     ArrayList<String> results = new ArrayList<>();
//     stream.filter(s -> pattern.matcher(s).matches())
//            .forEach(s -> results.add(s));  // Unnecessary use of side-effects!

//     List<String>results =
//        stream.filter(s -> pattern.matcher(s).matches())
//                .collect(Collectors.toList());  // No side-effects!

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
//        Collection.

    }
}
