package com.ukyu.base.enumtest;

import com.ukyu.base.StringTest;

import java.util.Arrays;

/**
 * @author ukyu
 * @date 2020/11/24
 **/
public enum  EnumDemo {
    PROGRAMMER(1),
    PRODUCT_MANAGER(2);

    int value;
    EnumDemo(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public static void main(String[] args) {
        for(EnumDemo demo:EnumDemo.values())
        {
            System.out.println(demo.ordinal()   + " " + demo.value + " " + demo.name());
        }



    }
}
