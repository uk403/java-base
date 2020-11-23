package com.ukyu.designpatterns.simplefactorymethod;

/**
 * 以程序员、产品经理为例子 4（满分5） -- 创建型模式
 *
 * 简单工厂模式（静态工厂方法模式）
 *
 * 优点： 1.对象的创建与对象的使用分离，将对象的创建交给专门的工厂类负责；  解耦*
 *       2. 不必记住具体产品类的类名，只需要知道具体产品类对应的参数即可，
 *          可以考虑使用全局变量，final static String xxx = ""; 对于复杂的类名，可以减少使用者的记忆量；
 *       3. 当使用外部配置文件来管理这些参数时，例如 xml、properties，
 *           还可以不改变代码，只需改变外部配置文件，就可以改变具体的产品类
 *
 * 缺点： 1. 当工厂类不正常工作时，整个系统都会受到影响
 *       2. 当产品类增加时，就必须修改工厂类的逻辑；产品类不停的创建，工厂类的逻辑会变得复杂，不利于系统的扩展性与维护性；
 *
 * 适用的场合： 1. 需要创建的对象较少，这样工厂类的逻辑就不会太复杂；
 *             2. 使用者不关心对象的创建过程，只需拿到该对象
 *
 * 模式的应用：
 *
 * 简单工厂模式
 * 不符合'开闭原则'，当想要添加一个新的产品时，会破坏工厂类
 * @author ukyu
 * @date 2020/11/19
 **/
public class SimpleFactoryMethod {
    public static void main(String[] args) {
        Worker worker0 = Leader.getWorker("Programmer");  // 可以通过配置文件和反射获得
        worker0.doWhat();
        Worker worker1 = Leader.getWorker("ProductManager");
        worker1.doWhat();

        // 模式的应用
//        DateFormat format =  DateFormat.getDateInstance();
//        new ThreadPoolExecutor();

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

class Leader{
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
//            //  Worker worker2 = Boss.getWorker("com.ukyu.designpatterns.simplefactorymethod.Programmer");
//            //  worker2.doWhat();
//            Class<?> clazz = Class.forName(position);
//            return (Worker) clazz.newInstance();
//        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
//            return null;
//        }
    }
}


