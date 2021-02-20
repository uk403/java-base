package com.ukyu.base.generics;

import com.ukyu.test.Female;
import com.ukyu.test.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author ukyu
 * @date 2021/2/19
 **/
public class GenericsDemox {
    public static void main(String[] args) {
        Sink<Object> s = null;
        Collection<String> cs = null;
        String str = writeAll(cs, s); // Illegal call.

//      下界通配符  <? super T> 最低的类是T    只存不取  （下面举例）
//      上界通配符  <? extends T> 最高的类是T  只取不存
//       又存又取，避免使用通配符
    }

    public void TestWildcards(List<? extends Person> list){

        // compile error
//        list.add()
//        允许编译器将通配符的未知类型作为泛型方法的类型参数进行推断
        wildcardsHelper(list);
        Person person = list.get(0);



    }

    private static <T> void wildcardsHelper(List<T> list){
        list.add((T) new Person());
    }

    public static <T> T writeAll(Collection<T> coll, Sink<? super T> snk) {
        T last = null;
        for (T t : coll) {
            last = t;
            snk.flush(last);
        }
        return last;
    }

}

interface Sink<T> {
    void flush(T t);
}
