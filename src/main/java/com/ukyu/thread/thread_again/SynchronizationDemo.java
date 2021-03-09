package com.ukyu.thread.thread_again;

/**
 * 同步； 线程通过访问共享的属性来进行交流；
 * 这样会导致线程干扰(Thread interference)&内存一致性错误(memory consistency error)
 *
 * synchronized的基本原理就是，(先画出java内存的模型），
 * 将在synchronized中使用到的共享变量从线程中全部清除，而是直接从主存中获取，
 * 退出synchronized，就是把synchronized块内修改后的共享变量直接刷新到主内存中
 *
 * @author ukyu
 * @time 2021/3/3 23:22
 */
public class SynchronizationDemo extends Thread{
//    线程干扰 https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html

//    内存一致性错误，使用 happens-before 关系来避免这个错误；这个关系保证，
//    即一个特定的语句对另一特定的语句可见的内存写操作；写操作要在读操作之前发生(保证共享变量的透明性)


//    synchronized 可以修饰方法与代码块(细粒度的同步)，但是不能在构造器上使用
//    因为在对象创建时，只有创建它的线程才可以访问它；
//    final的属性，对象被创建以后就不能改变了，所以该属性可以安全的读，在非同步的方法中，一旦对象创建后

//    Reentrant Synchronization(重入同步)，当一个线程需要一个它已经拥有的锁，这是允许的；

    public static void main(String[] args) {
        SynchronizationDemo t1 = new SynchronizationDemo();
        t1.setName("t1");
        SynchronizationDemo t2 = new SynchronizationDemo();
        t2.setName("t2");
        t1.start();
        t2.start();
    }

    // 此时的monitor(监视器)是调用方法的对象
    // 若同步修饰的是静态方法，则此时monitor就是类
    public  synchronized void show(){
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName() + " 打印： " + i);
        }
    }

    @Override
    public void run() {
        show();
    }

}