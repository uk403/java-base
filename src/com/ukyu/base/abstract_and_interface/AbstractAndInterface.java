package com.ukyu.base.abstract_and_interface;

import java.lang.reflect.Modifier;

/**
 * 抽象类与接口的区别与联系
 *
 * 包含抽象方法的类是抽象类，该类必须限定为抽象类
 * 抽象类的设计目的： 代码复用，是面向对象，对某个事物的具体化
 *
 * 什么时候使用： 1. 有一些可以有多个类通用的方法，共享通用或无聊的代码  都是相关对象
 *             2. 访问修饰符不仅仅是public
 *
 *
 * 接口的设计目的： 对类的行为进行约束,接口就是一个合同，实现接口的类必须存在接口规定的行为,表示某些行为，必须存在该行为，具体行为的实现不用管。完全抽象的类
 *
 * 什么时候使用： 1. 面向功能的，不用管对象是什么，只要具有该功能就行了
 *             2. 无关的对象
 *             3. 对实现接口的类，进行行为的约束，插座
 *             4. 需多继承时
 *
 * 接口也是类，只是完全抽象的类罢了
 * 抽象程度： 普通类 < 抽象类 < 接口
 * https://stackoverflow.com/questions/1913098/what-is-the-difference-between-an-interface-and-abstract-class
 *
 * https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
 * @author ukyu
 * @date 2020/12/10
 **/
public class AbstractAndInterface {

    public static void main(String[] args) {
        Class clazz = Light.class;
        System.out.println(Modifier.toString(clazz.getModifiers()));
    }

}

