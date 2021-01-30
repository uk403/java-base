package com.ukyu.base.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * 所有异常都是checked exception，除了 Error, RuntimeException, and their subclasses.
 * checked exception:
 * error: 错误； 解决方式： 打印堆栈并退出可能会更好一点                                      |
 * RuntimeException: 逻辑出错或者API使用不当； 解决方式：解决导致这个异常出现的bug可能会好一点    |  unchecked exception
 *
 * finally - 当执行try块或catch块时，jvm退出了，finally块才不会执行；
 *
 *
 * @author ukyu
 * @date 2021/1/25
 **/
public class ExceptionDemo1 {
    public static void main(String[] args) {

//        try{
//
//        }
//        // catch块处理多个异常时，则其参数隐式是final的，下面的ex就不能为其分配任何值
//        catch (NullPointerException | FileNotFoundException ex)
//        {
//            ex = (NullPointerException) new Exception();
//        }

        readFirstLineFromFile("C:\\Users\\ukyu\\Desktop\\未来.txt");
    }

    static String readFirstLineFromFile(String path) {
        //        try-with-resources statement
        // 写在try()中的对象必须implements java.lang.AutoCloseable，这样的对象才能被视为resources
        // 相当于
        // try
        // finally
        try (BufferedReader br =
                     new BufferedReader(new FileReader(path))) {
            int a = 3 / 0;
            return br.readLine();
        } catch (Exception e) {
//            可以找回被压制的异常 调用Throwable.getSuppressed()
            System.out.println(Arrays.toString(e.getSuppressed()));
            e.printStackTrace();
        }

        return null;

        // 也可以跟catch块或finally块，执行在声明resource关闭之后

        // 当try块中引发了异常，并且try-with-resources[在关闭某个资源时]也引发了一个或多个异常，try-with-resources语句中引发的异常将会被抑制

    }
}
