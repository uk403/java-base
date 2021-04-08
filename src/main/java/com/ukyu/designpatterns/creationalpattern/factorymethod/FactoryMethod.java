package com.ukyu.designpatterns.creationalpattern.factorymethod;

/**
 * 工厂模式
 * 不同的Leader，使用不同的人 5分  -- 创建型模式
 *
 * 定义:定义一个创建对象的接口，让其子类决定将哪一个类实例化。
 *     即，让一个类的实例化延迟到其子类
 *
 * 优点：继承了简单工厂模式的优点；1.不必关心对象如何创建
 *      添加新的产品时，无须修改其他的类，只需要增加一个具体产品与具体工厂就可以了
 *
 * 缺点：1. 正如上面优点所说，增加一个产品会增加一对类，所以一定程度增加系统的复杂度
 *
 * 适用的场景：调用者不知道它所需要的对象的类，只需要知道所对应的工厂就可以
 *
 * 扩展： 1.工厂方法的重载，Worker getWorker(); Worker getWorker(String stage); 程序员有p6、p7...
 *       2.工厂方法的隐藏，直接在具体的工厂类中调用所创建的业务方法，
 *
 * 总结：继承简单工厂模式的优点，当创建新的产品类时，无须修改现有的类
 *      新增产品时，其对应的工厂也要添加，类将会成对增加了
 * @author ukyu
 * @date 2020/11/20
 **/
public class FactoryMethod {
    public static void main(String[] args){
        Leader leader = new ProgrammerLeader();
        Worker worker = leader.getWorker();
        worker.doWhat();

        // 模式的应用
//        Connection conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://loc
//                alhost:1433; DatabaseName=DB;user=sa;password=");
//        Statement statement=conn.createStatement();
//        ResultSet rs=statement.executeQuery("select * from UserInfo");



    }
}

// 抽象产品类
interface Worker{
    void doWhat();
}

// 具体产品类
class Programmer implements Worker {

    @Override
    public void doWhat() {
        System.out.println("编程");
    }
}

class ProductManager implements Worker {

    @Override
    public void doWhat() {
        System.out.println("写需求，改需求~");
    }
}

// 抽象工厂类
interface Leader
{
    Worker getWorker();
}

// 具体工厂类
class ProgrammerLeader implements Leader{

    @Override
    public Worker getWorker() {
        return new Programmer();
    }
}

class ProductManagerLeader implements Leader{

    @Override
    public Worker getWorker() {
        return new ProductManager();
    }
}



