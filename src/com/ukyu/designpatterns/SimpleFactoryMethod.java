package com.ukyu.designpatterns;

/**
 * 程序员、产品经理
 *
 * 简单工厂模式
 * @author ukyu
 * @date 2020/11/19
 **/
public class SimpleFactoryMethod {
    public static void main(String[] args) {
        Worker worker0 = Boss.getWorker("Programmer");
        worker0.doWhat();
        Worker worker1 = Boss.getWorker("ProductManager");
        worker1.doWhat();


    }
}

class Programmer implements Worker{

    @Override
    public void doWhat() {
        System.out.println("编程");
    }
}

class ProductManager implements Worker{

    @Override
    public void doWhat() {
        System.out.println("写需求，改需求~");
    }
}

// 工厂
interface Worker{
    void doWhat();
}

class Boss{
    public static Worker getWorker(String position){
        if("Programmer".equals(position))
        {
            return new Programmer();
        }
        if("ProductManager".equals(position))
        {
            return new ProductManager();
        }
        return null;

//        try {
//            //  调用
//            //  Worker worker2 = Boss.getWorker("com.ukyu.designpatterns.Programmer");
//            //  worker2.doWhat();
//            Class<?> clazz = Class.forName(position);
//            return (Worker) clazz.newInstance();
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            return null;
//        }
    }
}
