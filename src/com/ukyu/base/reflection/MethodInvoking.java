package com.ukyu.base.reflection;

import java.util.Arrays;

/**
 * @author ukyu
 * @date 2020/12/21
 **/
public class MethodInvoking {

    public void method(Integer name, String... args) {
        System.out.println("调用普通参数可变方法");
        System.out.println(name);
        System.out.println(Arrays.toString(args));
    }

    private void privateMethod() {
        System.out.println("调用普通私有方法");
    }

    public void throwMethod() {
        throw new RuntimeException("抛出运行时错误");
    }

    public static void staticMethod() {
        System.out.println("调用静态方法");
    }


}
