package com.ukyu.thread.thread_again.concurrent_again;

/**
 * java8的原子操作
 * @author ukyu
 * @date 2021/3/10
 **/
public class Atomic_8 {
//    AtomicLong是通过非阻塞算法CAS(用的Unsafe类中的方法)来实现的原子性操作
//    但是在高并发中, 大量线程去更新同一个原子变量, 但只有一个会成功,
//    会通过无限循环不断进行自旋尝试CAS操作, 这样白白浪费CPU资源

//    LongAdder, 把变量分成多个变量(获取LongAdder当前值时,
//          将所有的Cell变量的value累加后再加上base返回)
//    相当于多个变量去争抢多个变量, 减少了争夺共享资源的并发量
//    LongAdder 是下面这个类的特例
//    LongAccumulator可以自定义两个参数的计算规则
//    LongAdder

}

