package com.ukyu.base.iterator;

import java.util.*;

/**
 * 迭代器的demo
 * @author ukyu
 * @date 2021/1/13
 **/
public class IteratorDemo {
    public static void main(String[] args) {
//        某个列表implements Iterable 表明该类能产生迭代器
        ArrayList<String> list = new ArrayList<>(Arrays.asList("Apple", "Orange", "Pear"));
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
        Spliterator<String> spliterator = list.spliterator();

    }
}
