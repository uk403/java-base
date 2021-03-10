package com.ukyu.thread.thread_again;

import lombok.extern.log4j.Log4j;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 基本上都是native的方法，调用的是c++实现的方法
 *
 * https://tech.meituan.com/2019/02/14/talk-about-java-magic-class-unsafe.html
 * @author ukyu
 * @date 2021/3/9
 **/
@Log4j
public class UnsafeDemo {
    public static void main(String[] args) throws NoSuchFieldException {

        Unsafe unsafe = reflectGetUnsafe();
//        指定变量在所属类中的内存偏移地址
        Long offset = unsafe.objectFieldOffset(AtomicLong.class.getDeclaredField("value"));
        log.info("offset: " + offset);
    }

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            // 获取这个filed的值，若不是静态对象必须传入对应的对象，反之，什么都可以传入，包括null
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }
}

