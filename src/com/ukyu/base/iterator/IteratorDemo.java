package com.ukyu.base.iterator;

import java.util.Arrays;
import java.util.List;

/**
 * 迭代器的demo
 * @author ukyu
 * @date 2021/1/13
 **/
public class IteratorDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Orange", "Pear");
        for (String s : list) {
            System.out.println(s);
        }

//        foreach -> 迭代器的方式
//        列表调用其迭代器
//        数组调用自身的循环
        list.listIterator();


    }
}
