package com.ukyu.designpatterns.creationalpattern.abstractfactory;

/**
 * 抽象工厂模式 5  -- 创建型模式
 *
 * 需要多个产品对象时，
 * 定义：超级工厂创建其他的工厂。将工厂的类型抽象
 *
 * 产品等级结构 ：产品等级结构即产品的继承结构，如一个抽象类是电视机，其子类有海尔电视机、海信电视机、TCL电视机，
 * 则抽象电视机与具体品牌的电视机之间构成了一个产品等级结构，抽象电视机是父类，而具体品牌的电视机是其子类。
 *
 * 产品族 ：在抽象工厂模式中，产品族是指由同一个工厂生产的，位于不同产品等级结构中的一组产品，
 * 如海尔电器工厂生产的海尔电视机、海尔电冰箱，海尔电视机位于电视机产品等级结构中，海尔电冰箱位于电冰箱产品等级结构中。
 * 例子来源于：https://design-patterns.readthedocs.io/zh_CN/latest/creational_patterns/abstract_factory.html
 *
 * 优点： 增加新的工厂比较容易，在现有的产品等级结构上扩展比较容易(抽象电视机，子类有海尔电视、TCL电视，我想扩展一个小米电视，
 *  只需要添加一个小米的具体产品类，修改电视机工厂的具体类即可)
 *
 * 缺点： 增加一个产品族比较麻烦，会修改抽象工厂类以及其子类相关的修改；抽象工厂角色规定了所有可能被创建的产品集合；
 *
 * 其实也好理解，现有的工厂都具有生产某个东西，想生产其他品牌的东西，大不了就贴个牌，大致的东西不会变的；但是没有相应产品的工厂，
 * 想生产该产品，岂不是很难。 一个造打火机的工厂，你让它造火箭，很难，但是没有可能。
 *
 * 适合场景：
 *   1. 系统中有多于一个的产品族，而每次只使用其中某一产品族。
 *
 * @author ukyu
 * @date 2020/11/23
 **/
public class AbstractFactoryDemo {

    public static void main(String[] args) {
        AbstractFactory editorFactory = FactoryProducer.getFactory("editor");
        Editor editor1 = editorFactory.getEditor("vscode");
        editor1.write();
        Editor editor2 = editorFactory.getEditor("vim");
        editor2.write();

        AbstractFactory browserFactory = FactoryProducer.getFactory("browser");
        Browser browser1 = browserFactory.getBrowser("chrome");
        browser1.use();
        Browser browser2 = browserFactory.getBrowser("ie");
        browser2.use();


    }
}

interface Browser{
    // 使用浏览器
    void use();
}

class Chrome implements Browser {

    @Override
    public void use() {
        System.out.println("谷歌浏览器");
    }
}

class Ie implements Browser {

    @Override
    public void use() {
        System.out.println("IE浏览器");
    }
}

interface Editor{
    // 编辑器
    void write();
}

class VimEditor implements Editor{

    @Override
    public void write() {
        System.out.println("使用vim进行编辑");
    }
}

class VscodeEditor implements Editor{

    @Override
    public void write() {
        System.out.println("使用Vscode进行编辑");
    }
}

abstract class AbstractFactory{

    abstract Editor getEditor(String editorType);

    abstract Browser getBrowser(String browserType);

}

class BrowserFactory extends AbstractFactory{

    @Override
    Editor getEditor(String editorType) {
        return null;
    }

    @Override
    Browser getBrowser(String browserType) {
        if("ie".equalsIgnoreCase(browserType)) {
            return new Ie();
        }

        if("chrome".equalsIgnoreCase(browserType))
        {
            return new Chrome();
        }
        return null;
    }
}

class EditorFactory extends AbstractFactory{

    @Override
    Editor getEditor(String editorType) {
        if("vscode".equalsIgnoreCase(editorType))
        {
            return new VscodeEditor();
        }
        if("vim".equalsIgnoreCase(editorType))
        {
            return new VimEditor();
        }
        return null;
    }

    @Override
    Browser getBrowser(String browserType) {
        return null;
    }
}

class FactoryProducer {
    static AbstractFactory getFactory(String factoryType) {
        if ("editor".equalsIgnoreCase(factoryType)) {
            return new EditorFactory();
        }

        if ("browser".equalsIgnoreCase(factoryType)) {
            return new BrowserFactory();
        }
        return null;
    }
}









