package com.ukyu.base.thread;

/**
 * @author ukyu
 * @date 2020/8/3
 * 消费者 生产者问题
 **/

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Thread t1 = new Thread(new Product(clerk));
        Thread t2 = new Thread(new Consumer(clerk));
        t1.start();
        t2.start();

    }
}

class Clerk{

    private int num = 0;
    public synchronized void produceProduct() {
        if(num<20)
        {
            num++;
            System.out.println(Thread.currentThread().getName()+":生产第 "+num+" 个");
            notify();
        }
        else {
            //
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumerCon() {
        if(num>0)
        {
            num--;
            System.out.println(Thread.currentThread().getName()+":消费第 "+num+" 个");
            notify();
        }
        else
        {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Product implements Runnable{

    private Clerk clerk;

    public Product(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run()
    {
        System.out.println("开始生产！！！！！！");
        while(true)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.produceProduct();

        }
    }
}

class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public void run() {
        {
            System.out.println("开始消费！！！！！！");
            while(true)
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clerk.consumerCon();

            }
        }
    }
}

