package com.ukyu.designpatterns.abstractfactory;

/**
 * 抽象工厂模式 5  -- 创建型模式
 *
 * 需要多个产品对象时，
 * 定义：超级工厂创建其他的工厂。将工厂的类型抽象
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









