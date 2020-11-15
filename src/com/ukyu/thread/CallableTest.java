package com.ukyu.thread;

import java.sql.SQLOutput;
import java.util.concurrent.*;

/**
 * @author ukyu
 * @date 2020/8/3
 **/
public class CallableTest {


    public static void main(String[] args) {
        NumTest numTest = new NumTest();
        FutureTask<Integer> future = new FutureTask<>(numTest);
        new Thread(future).start();
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        CyclicBarrier
    }
}

class NumTest implements Callable{

    @Override
    public Object call() throws Exception {
        int num = 0;
        for(int i=0;i<=100;i++)
        {
            num+=i;
        }
        return num;
    }
}
