package com.ukyu.base.reflection;

import java.io.Serializable;
import java.util.List;

/**
 * 反射所用的实体
 * @author ukyu
 * @date 2020/12/20
 **/
public class Person implements Serializable, Cloneable {

    private String name;

    private static double Height;

    private double weight;

//    public Person(){
//
//    }

    public Person(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    //
//    public Person(String name, double weight, double height){
//
//        this.name = name;
//        Person.Height = height;
//        this.weight = weight;
//    }

    public void publicMethod(String name, List<Integer> nums){

        System.out.println("name: " + name + "nums" + nums);
    }

    private void privateMethod(double weight){
        System.out.println(weight);
    }

    public static void staticMethod(){
        System.out.println(Height);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
