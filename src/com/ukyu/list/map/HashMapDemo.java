package com.ukyu.list.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 从树节点变回普通的bins?
 *
 * 说说对Implementation notes的理解
 *
 * 为什么树化门槛是8
 *
 * hash为什么那么计算？
 *
 * tableSizeFor 将自定义的容量变成2的次幂
 *
 * getNode 获取树节点
 *
 * putVal 添加val的时候
 *
 * 有可能值就为空，有可能没有值所以为空
 *
 * put值的过程
 * 扩容
 *
 * 3种遍历方式
 *
 * 新的方法使用，
 * 1. computeIfAbsent 2. computeIfPresent  3. compute 4. merge 5.
 * @author ukyu
 * @date 2020/12/26
 **/
public class HashMapDemo {
    public static void main(String[] args) {
        // key和value可为空
//        Map<String, String> map = new HashMap<>(30);
//        map.put("name", "ukyu");
//        map.put("dream", "money");
//        for (Map.Entry<String, String> set : map.entrySet()) {
//            System.out.println(set.getKey() + ":" + set.getValue());
//        }

    }
}
