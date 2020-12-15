package com.ukyu.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author ukyu
 * @date 2020/11/17
 **/
public class Test {
    private static final int total = 10;

    public static void main(String[] args) {
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < total; i++)
        {
            Person p = new Person();
            p.setName("ukyu" + new Random().nextInt());
            p.setRuleId(i);
            list.add(p);
        }


    }
}

//class Demo<T extends Person>
//{
//    public void gd(List<T> tList)
//    {
//        tList.forEach(System.out::println);
//    }
//}
