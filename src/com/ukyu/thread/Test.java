package com.ukyu.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ukyu
 * @date 2020/10/18
 **/
public class Test extends Thread{
    private static AtomicInteger ai = new AtomicInteger();

    public Test(String name){
        super(name);
    }

    @Override
    public void run() {
        try
        {
            for (int i = 0; i < 3; i++)
            {
                Tools.t1.set(ai.addAndGet(1) + "");
                System.out.println(this.getName() + " get value--->" + Tools.t1.get());
                Thread.sleep(200);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
