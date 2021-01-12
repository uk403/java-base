package com.ukyu.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author ukyu
 * @date 2020/12/24
 **/
public class LinkedListDemo {
    public static void main(String[] args) {
        // 双链表结构
        LinkedList<Double> list = new LinkedList<>();
//        // addLast()方法一样
//        list.add(1d);
//        list.add(2d);
//        list.add(2d);
//        System.out.println(list);

        // remove 删除最低的index的值
//         list.remove(2d);
//        System.out.println(list);

        // addAll() 分析加在index <= size的
//        返回特定索引的非空节点(减少遍历的次数)
//        LinkedList.Node<E> node(int index) 重点讲讲
//        list.addAll(1, Arrays.asList(7d, 8d));
//        System.out.println(list);

        //--- 其他方法
        // 差不多，getFirst(),为空的话，会报错NoSuchElementException
//        list.peek();
//        list.element();
//        list.getFirst();
//        list.poll();



        final  int SIZE = 100000;
        ArrayList<Integer> arrayList = new ArrayList<>();
        long start = System.currentTimeMillis();
        for(int i = 0;i < SIZE; )
        {
            arrayList.add(i);
            i++;
        }
        System.out.println((System.currentTimeMillis() - start));

        LinkedList<Integer> linkedList = new LinkedList<>();
        long start1 = System.currentTimeMillis();
        for(int i = 0;i < SIZE; )
        {
            linkedList.add(i);
            i++;
        }
        System.out.println((System.currentTimeMillis() - start1));


        // RandomAccess讲讲这个接口-

    }
}
