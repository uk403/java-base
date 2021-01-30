package com.ukyu.base.abstract_and_interface;

/**
 * @author ukyu
 * @date 2020/12/11
 **/
public class ImplTurn implements Turn {

    @Override
    public void turnOn() {
        System.out.println("用手开");
    }

    @Override
    public void turnOff() {
        System.out.println("声音关");
    }
}
