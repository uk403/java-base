package com.ukyu.base.generics;

import java.util.LinkedList;
import java.util.List;

/**
 * 泛型
 * jdk5引进的泛型
 * @author ukyu
 * @time 2021/2/3 15:44
 */
//@Slf4j
public class GenericsDemo {

    public static void main(String[] args) {
        // 1
        List myIntList = new LinkedList();
        // 2
        myIntList.add(new Integer(0));
        // 3
        Integer x = (Integer) myIntList.iterator().next();

        // 使用泛型后
        List<Integer> myIntList1 = new LinkedList<>(); // 1'
        myIntList1.add(new Integer(0)); // 2'
        Integer x1 = myIntList1.iterator().next(); // 3'
//      其作用：不仅是解决了转化类型的混乱，还在编译期就检测类型是否正确
//      提供可读性



//        log.info(test("Hello world!"));
    }

    /**
     * 参数与返回类型之间有依赖关系，可以使用泛型方法
     * 泛型方法
     */
    private static  <T> T test(T x){
        return x;
    }
//    static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
//        for (T o : a) {
//            c.add(o); // Correct
//        }
//    }

    public static <T, S extends T> void copy(List<T> dest, List<S> src){

    }


    // 有界符 A
//    public void drawAll(List<? extends Shape> A) {
////        do something
//    }

//    public String loophole(Integer x) {
//        List<String> ys = new LinkedList<String>();
//        List xs = ys;
//        xs.add(x); // Compile-time unchecked warning
//        return ys.iterator().next();
//    }

    public String loophole(Integer x) {
        List ys = new LinkedList();
        List xs = ys;
        xs.add(x);
        return(String) ys.iterator().next(); // run time error
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



