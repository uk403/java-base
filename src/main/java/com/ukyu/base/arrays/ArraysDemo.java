package com.ukyu.base.arrays;

import java.util.Arrays;

/**
 * Arrays
 * @author ukyu
 * @date 2021/2/23
 **/

public class ArraysDemo {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 0, 21, 3, 6};
//        排序算法，后面好好研究下
//        Arrays.sort();
//        利用ForkJoinPool的思想，后期研究
//        Arrays.parallelSort(a);

//        遍历整个数组，对当前索引前一个的值与当前索引的值进行操作，然后覆盖当前索引的值
//        Arrays.parallelPrefix(a, (x, y) -> x + y);

//        log.info(Arrays.hashCode(a));

//        遍历整个数组，对当前索引进行操作，然后覆盖当前索引的值
        Arrays.parallelSetAll(a, x -> x*4);

        Arrays.stream(a).forEach(x -> System.out.print(x + " "));


    }
}
