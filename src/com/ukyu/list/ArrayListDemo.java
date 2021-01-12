package com.ukyu.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * ArrayList源码解析
 *
 * 默认值是10
 * Default initial capacity.
 * 三种构造器
 *
 * transient Object[] elementData; // non-private to simplify nested class access
 *
 * private static final int DEFAULT_CAPACITY=10;
 * @author ukyu
 * @date 2020/12/16
 **/
public class ArrayListDemo {
    public static void main(String[] args) {
        // 报错 Requested array size exceeds VM limit
         /* The maximum size of array to allocate.
          * Some VMs reserve some header words in an array.
          * Attempts to allocate larger arrays may result in
          * OutOfMemoryError: Requested array size exceeds VM limit
          */
        ArrayList<String> list = new ArrayList<>(Integer.MAX_VALUE - 8);
//        int[] a = new int[];

//        System.out.println(Integer.MAX_VALUE );

//        int[] elementData = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        // 10 -> 1010 0101->5 每次扩展1.5倍
//        int oldCapacity = 10;
//        int newCapacity = oldCapacity + (oldCapacity >> 1);
//        System.out.println(newCapacity);
//        elementData = Arrays.copyOf(elementData, 15);
//        System.out.println(Arrays.toString(elementData));

        // 添加第一个参数时，才会初始化数组
        // 每次都要检查，是否需要扩容

// 浅拷贝，存在的元素重新复制一个值给克隆出的对象,不会影响值
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        ArrayList<String> list1 = (ArrayList<String>) list.clone();
//        list1.remove(2d);
//        System.out.println(list);
//        System.out.println(list1);

//        modCount 删除与添加都有modCount++操作

        // 整理一下System.arraycopy用法
        // index那个目标的元素，及以后的都向右移一位
//        int[] elementData = new int[15];
//        for(int i = 0; i < 10; i++)
//        {
//            elementData[i] = i;
//        }
//        System.out.println(Arrays.toString(elementData));
//        int index = 4;
//        System.out.println(elementData.length);
//        System.arraycopy(elementData, index, elementData, index + 1,
//                elementData.length - 1 - index);
//        System.out.println(Arrays.toString(elementData));
//        结合remove方法


//总结 System.arraycopy()的用法
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {0, 0, 0, 0, 0, 6, 8, 9, 10};
//        System.arraycopy(a, 0, b, 0, 5);
//        System.out.println(Arrays.toString(b));

        //把满足条件的放在最前面
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        list.add(5d);
//
//        ArrayList<Double> list1 = new ArrayList<>();
//        list1.add(2d);
//        list1.add(3d);
//        list1.add(4d);
//        list.removeAll(list1);
//        list.retainAll(list1);
//        System.out.println(list);

        //----listIterator 后面详细介绍
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        list.add(5d);
//        ListIterator<Double> iterator = list.listIterator();
//        iterator.forEachRemaining(x -> System.out.println(x.doubleValue()));
//        while(iterator.hasNext())
//        {
//            System.out.println(iterator.next());
//        }

//        -----subList 消除范围操作的需要，可以当作是一个子ArrayList操作
//        // [fromIndex, toIndex)
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        list.add(5d);
//        list.subList(1, 3).clear();
//        System.out.println(list);


//        ----spliterator
//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        list.add(5d);
//        list.spliterator();

//        ArrayList<Double> list = new ArrayList<>();
//        list.add(1d);
//        list.add(2d);
//        list.add(3d);
//        list.add(4d);
//        list.add(5d);
//        list.removeIf(x -> x > 4);
//        System.out.println(list);

//        int[] a = {};
//        a = Arrays.copyOf(a, 10);
//        System.out.println(Arrays.toString(a));
//        a[9] = 9;


    }
}
