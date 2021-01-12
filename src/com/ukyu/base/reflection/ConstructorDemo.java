package com.ukyu.base.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 构造器 为了创建类实例对象
 * @author ukyu
 * @date 2020/12/22
 **/
public class ConstructorDemo {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.ukyu.base.reflection.Person");
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        for(Constructor<?> constructor: constructors)
        {
            System.out.println(constructor.toGenericString());

            // 构造器的修饰符
            //Access modifiers: public, protected, and private
            //Annotations
            System.out.println("Modifier: " + Modifier.toString(constructor.getModifiers()));
        }

//        创建类的实例
        //Class.newInstance() can only invoke the zero-argument constructor,
        // while Constructor.newInstance() may invoke any constructor, regardless of the number of parameters.

        //Class.newInstance() throws any exception thrown by the constructor, regardless of whether it is checked or unchecked.
        //Constructor.newInstance() always wraps the thrown exception with an InvocationTargetException.

        //Class.newInstance() requires that the constructor be visible;
        // Constructor.newInstance() may invoke private constructors under certain circumstances.
        Constructor<?> constructor = clazz.getConstructor(String.class, double.class);
        Person person = (Person) constructor.newInstance("hi", 10);
        System.out.println(person);

        // new 与 Constructor的最重要的区别: new 会执行类型检测、拆装箱、（方法解析？）



    }
}
