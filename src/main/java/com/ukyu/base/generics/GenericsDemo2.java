package com.ukyu.base.generics;

import java.util.Collection;

/**
 * 通配符
 * @author ukyu
 * @time 2021/2/19 22:30
 * https://docs.oracle.com/javase/tutorial/extra/generics/morefun.html
 */
public class GenericsDemo2 {

    public static void main(String[] args) {
        Collection<String> cs = null;
        Sink<Object> s = null;
        String str = writeAll(cs, s);
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