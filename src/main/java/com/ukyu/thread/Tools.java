package com.ukyu.thread;

import com.ukyu.test.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ukyu
 * @date 2020/10/18
 **/
public class Tools{
    public static ThreadLocal t1 = new ThreadLocal();

    public static void main(String[] args) {
        List<Person> strings = new ArrayList<>();

        Person p1 = new Person();
        p1.setName("刘");

        Person p2 = new Person();
        p2.setName("哥哥");



        Person[] str = {p1, p2};
        Person a = new Person();
        for (int i = 0; i < 2; i++) {
            a.setName(str[i].getName());
            strings.add(a);
        }
        System.out.println(strings);

    }
}
