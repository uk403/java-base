package com.ukyu.base.stream;

import com.ukyu.test.Person;
import lombok.Data;

/**
 *
 * @author ukyu
 * @date 2021/2/25
 **/
public class LambdaScopeTest {


    public MyFunction getFunction(){
        Person person = new Person();
        return new MyFunction() {
            @Override
            public int add(int a, int b) {
//           x = 3;
           return  a + b;
            }
        };
    }

    public static void main(String[] args) {
        TestScope ts = new TestScope();
        TestScope ts1 = ts;
        ts1 = new TestScope();
        System.out.println(ts);
        System.out.println(ts1);
    }

}
interface MyFunction{
    int add(int a, int b);
}

class TestScope{
    private int test;
}