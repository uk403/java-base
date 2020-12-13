package com.ukyu.base.abstract_and_interface;

/**
 * @author ukyu
 * @date 2020/12/11
 **/
class LightExtends extends Light {

    @Override
    void turn() {
        System.out.println("关闭~");
    }

    public static void main(String[] args) {
        Light light = new LightExtends();
        System.out.println(light.getBrightness(100));
        light.turn();
    }
}
