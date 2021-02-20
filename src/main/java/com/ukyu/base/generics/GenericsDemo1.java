package com.ukyu.base.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ukyu
 * @time 2021/2/18 22:45
 */
public class GenericsDemo1 {
    public static void main(String[] args) {

        // 泛型的擦除

        List<String> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        // 所有的泛型类都有相同的运行时类，不会管其具体的参数类型.
        System.out.println(l1.getClass() == l2.getClass());



    }
}
