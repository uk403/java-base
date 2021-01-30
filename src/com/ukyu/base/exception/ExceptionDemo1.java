package com.ukyu.base.exception;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 所有异常都是checked exception，除了 Error, RuntimeException, and their subclasses.
 * 都是Throwable的子类
 * checked exception:
 * error: 错误； 解决方式： 打印堆栈并退出可能会更好一点                                      |
 * RuntimeException: 逻辑出错或者API使用不当； 解决方式：解决导致这个异常出现的bug可能会好一点    |  unchecked exception
 *
 * The try block identifies a block of code in which an exception can occur.
 * The catch block identifies a block of code, known as an exception handler, that can handle a particular type of exception.
 * The finally block identifies a block of code that is guaranteed to execute, and is the right place to close files, recover resources, and otherwise clean up after the code enclosed in the try block.
 * finally - 当执行try块或catch块时，jvm退出了，finally块才不会执行；
 *
 * throw 抛出的异常对象都是Throwable的子类
 *
 * 子类异常与父类异常捕获的顺序原因：
 *  1. 异常的捕获是就近原则
 *  2. 异常捕获的类型是自身以及其子类的异常
 *  所以，写在父类后面的异常，永远不会被捕获，且编译失败
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

//        readFirstLineFromFile("C:\\Users\\ukyu\\Desktop\\未来.txt");

        try {
            Handler handler = new FileHandler("1.txt");
            throw new FileNotFoundException();
        } catch (IOException e) {
            Logger logger = Logger.getLogger("package.name");
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                logger.log(Level.WARNING, element.getMethodName());
            }

        }
//        catch(FileNotFoundException ex)
//        {
//
//        }

        // Unchecked Exceptions — The Controversy
//        将异常视为Unchecked Exception还是checked Exceptions 是有争议的，
//        Unchecked Exception 可以不用去catch或者指定某个异常
//        If a client can reasonably be expected to recover from an exception, make it a checked exception.
//        If a client cannot do anything to recover from the exception, make it an unchecked exception.
//        https://docs.oracle.com/javase/tutorial/essential/exceptions/runtime.html

        // 使用异常在你程序中的优点

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
        }
        return null;

        // 也可以跟catch块或finally块，执行在声明resource关闭之后

        // 当try块中引发了异常，并且try-with-resources[在关闭某个资源时]也引发了一个或多个异常，try-with-resources语句中引发的异常将会被抑制


//        ***Chained Exceptions***

    }
}
