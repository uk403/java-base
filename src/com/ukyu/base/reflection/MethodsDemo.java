package com.ukyu.base.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * The java.lang.reflect.Method class provides APIs to access information about a method's modifiers, return type,
 * parameters, annotations, and thrown exceptions. It also be used to invoke methods
 * @author ukyu
 * @date 2020/12/20
 **/
public class MethodsDemo
{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//            Class<?> clazz = Class.forName("java.util.ArrayList");
//
//            Method method = clazz.getMethod("add", Object.class);

            // 方法是怎么声明，它就输出什么
//            System.out.println(method.toGenericString());
//
//            Method[] methods = clazz.getDeclaredMethods();
//
//            Arrays.stream(methods).
//                    filter(x -> x.getName().contains("add")).
//                    forEach(System.out::println);


//            Access modifiers: public, protected, and private
//            Modifier restricting to one instance: static
//            Modifier prohibiting value modification: final
//            Modifier requiring override: abstract
//            Modifier preventing reentrancy: synchronized
//            Modifier indicating implementation in another programming language: native
//            Modifier forcing strict floating point behavior: strictfp
//            Annotations

//            ---调用方法
        Class<?> clazz = null;
        try {
            clazz = Class.forName("com.ukyu.base.reflection.MethodInvoking");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        MethodInvoking invoking = new MethodInvoking();
        Method method = clazz.getDeclaredMethod("method", Integer.class, String[].class);
        method.invoke(invoking, 1, new String[]{"ukyu", "hello world!"});
//        Object o = (Object) new String[]{"ukyu", "hello world!"};
//        System
//        .out.println(o.toString());
//        // 私有方法
//        Method method1 = clazz.getDeclaredMethod("privateMethod");
//        method1.setAccessible(true);
//        method1.invoke(invoking, null);
//        // 静态方法
//        // If the method is static, the first argument should be null.
//        Method method2 = clazz.getMethod("staticMethod");
//        method2.invoke(invoking);
        // 抛出错误的方法 可以用InvocationTargetException接受异常
        Method method3 = null;
        try {
            method3 = clazz.getMethod("throwMethod");
            method3.invoke(invoking,  null);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            Throwable cause = e.getCause();
            System.out.println(cause.getMessage());
        }


    }
}

