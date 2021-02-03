package com.ukyu.base.generics;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ukyu
 * @time 2021/2/3 15:44
 */
@Slf4j
public class GenericsDemo {

    public static void main(String[] args) {
        // 1
        List myIntList = new LinkedList();
        // 2
        myIntList.add(new Integer(0));
        // 3
        Integer x = (Integer) myIntList.iterator().next();

        // 使用泛型后
        List<Integer>
                myIntList1 = new LinkedList<>(); // 1'
        myIntList1.add(new Integer(0)); // 2'
        Integer x1 = myIntList1.iterator().next(); // 3'
//      其作用：不仅是解决了转化类型的混乱，还在编译期就检测类型是否正确
//      提供可读性






        log.info(test("Hello world!"));
    }

    /**
     * 泛型方法
     */
    private static <T> T test(T x){
        return x;
    }
}

//定义一个简单的泛型
//public interface List <E> {
//    void add(E x);
//    Iterator<E> iterator();
//}
//

//public interface Iterator<E> {
//    E next();
//    boolean hasNext();
//}
