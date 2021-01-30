package com.ukyu.base.clone;

import java.io.Serializable;

/**
 * @author ukyu
 * @date 2020/12/17
 **/
public class Male implements Serializable {
    private int age;

    private String color;

    public Male(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }



    @Override
    public String toString() {
        return "Male{" +
                "age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
