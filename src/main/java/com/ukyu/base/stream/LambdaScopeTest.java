package com.ukyu.base.stream;

import java.util.function.Consumer;

/**
 * 访问封闭类中的局部变量
 * @author ukyu
 * @date 2021/2/25
 **/
public class LambdaScopeTest {

    public int x = 1;

    class FirstLevel {

        public int y = 3;

        int methodInFirstLevel() {

            // The following statement causes the compiler to generate
            // the error "local variables referenced from a lambda expression
            // must be final or effectively final" in statement A:
//             x = 99;
//            和匿名类一样，lambda表达式也只能访问final或最终final(没有改变它)的值
//            为什么是final的原因，展示一下编译后的文件，会将内部引用的外部的值进行复制
//            若传递的是引用类型，我们可以修改其引用对象的值，原因，可以看看final的知识

            return x + y;
        }
    }

    public static void main(String... args) {
        LambdaScopeTest st = new LambdaScopeTest();
        LambdaScopeTest.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel();
    }
}
