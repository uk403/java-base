package com.ukyu.base.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Reflection is commonly used by programs
 * which require the ability to examine or modify the runtime behavior of applications running in the Java virtual machine
 *
 * https://docs.oracle.com/javase/tutorial/reflect/index.html
 * @author ukyu
 * @date 2020/12/20
 **/
public class Demo {

    static Object o = new Object(){
        public void m(){

        }
    };

    public static void main(String[] args) throws ClassNotFoundException {
        // Object类提供检查运行时对象的属性(包括成员变量与类信息)
        // 也提供了创建新类与对象的能力
        // 是所有反射APIs的入口

        // 获取某个类
//        xx.getClass()

        // 可以用Class.forName(类的全限定名字)获取这个类

        // 原始类型与void的包装类型'.type' 等价于 其'.class'
//        Class c = Integer.TYPE;
//        System.out.println(c);

        // ------------- 返回类的方法

//        Class clazz = ArrayList.class;
//        // 返回类的超类
//        System.out.println(clazz.getSuperclass());
//        // 返回属于该类成员以及继承成员的所有公共类，接口和枚举，包括。
//        System.out.println(Arrays.toString(clazz.getClasses()));
//        // 返回定义在该类中的所有类、接口、枚举
//        System.out.println(Arrays.toString(clazz.getDeclaredClasses()));
//        // 返回该类的直接封闭类, o定义的匿名类被com.ukyu.base.reflection.Demo封闭
//        System.out.println(o.getClass().getEnclosingClass());

        // 典型错误在使用反射时
//        Class<?> clazz = ArrayList.class;
//        try {
//            Method constructor = clazz.getMethod("size");
//
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        // 无参构造是不可见时，将不能获取新的实例
        Class<?> clazz = Class.forName("com.ukyu.base.reflection.Cls");
        try {
//              跟关键字'new'行为差不多
            Field field = clazz.getDeclaredField("field");
            Cls cls = (Cls) clazz.newInstance();
            // 不管是什么访问修饰符初始化都是'false'，
            // 但是要修改某个private的值，必须将accessible设置为'true'
            System.out.println(field.isAccessible());
            field.setAccessible(true);
            field.setInt(cls, 3);
            System.out.println(cls);

        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }


    }
}

class Cls {
    private int field;
    public int publicField;

    @Override
    public String toString() {
        return "Cls{" +
                "field=" + field +
                ", publicField=" + publicField +
                '}';
    }
}
