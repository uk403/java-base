package com.ukyu.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ukyu
 * @date 2020/11/17
 **/
public class Test {
    private static final int total = 10;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
//        List<Person> list = new ArrayList<>();
//        for(int i = 0; i < total; i++)
//        {
//            Person p = new Person();
//            p.setName("ukyu" + new Random().nextInt());
//            p.setRuleId(i);
//            list.add(p);
//        }
        Method method = Class.forName("com.ukyu.test.Test").getDeclaredMethod("setTotal");
    }
    public void setTotal(){

    }
}



//class Demo<T extends Person>
//{
//    public void gd(List<T> tList)
//    {
//        tList.forEach(System.out::println);
//    }
//}
