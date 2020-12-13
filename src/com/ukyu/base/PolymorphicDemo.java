package com.ukyu.base;

/**
 * 关于多态(运行时绑定、动态绑定)
 * 对象可以作为自己本身的类型使用，也可以作为它的基类型使用
 * 定义： 不同类(继承至同一个基类)的对象对同一个消息的不同的响应；发送消息给某个对象，做什么事情让该对象断定；
 *
 *
 * 只有普通方法调用是多态，静态方法、域不行
 * 将改变的事物与未变的事物分离开，我们只与基类打交道，消除类型之间的耦合性；
 * @author ukyu
 * @date 2020/11/21
 **/
public class PolymorphicDemo {
    public static void main(String[] args) {
        Vehicle vehicle = new Car();

        System.out.println(vehicle.getClass());
        getVehicle(vehicle);

        Car car = (Car)vehicle;
        System.out.println(car.wheelNum);
    }

    private static void getVehicle(Vehicle v)
    {
        // 看不出来是调用哪一个类的方法
        v.transport();
    }

}

class Vehicle {
    void transport() {
        System.out.println("运输~");
    }
}

class Car extends Vehicle{
    int wheelNum = 4;

    @Override
    void transport() {
        System.out.println("地上运输");
    }

}

class Plane extends Vehicle{
    @Override
    void transport() {
        System.out.println("天上运输");
    }
}