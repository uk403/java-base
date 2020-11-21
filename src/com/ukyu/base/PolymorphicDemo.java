package com.ukyu.base;

/**
 * 关于多态
 * 定义： 某个类型的方法调用，真正调用的方法取决于运行时实际类型的方法
 * @author ukyu
 * @date 2020/11/21
 **/
public class PolymorphicDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();
        vehicle.transport();
    }

}

class Vehicle{
    void transport(){
        System.out.println("运输~");
    }
}

class Car extends Vehicle{
    @Override
    void transport() {
        System.out.println("车子运输");
    }
}

class Plane extends Vehicle{
    @Override
    void transport() {
        System.out.println("灰机运输");
    }
}