package com.ukyu.base.abstract_and_interface;

/**
 * @author ukyu
 * @date 2020/12/11
 **/ // 飞行器
abstract class Light implements Turn{
    int brightness = 0;

    int getBrightness(int brightness) {
        return (this.brightness = brightness);
    }

    // 访问的权限
    abstract void turn();


    @Override
    public void turnOn() {

    }

    @Override
    public void turnOff() {

    }
}

