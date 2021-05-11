package com.ukyu.thread.thread_again.concurrent_again;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CountDownLatchDemo
 * @author ukyu
 * @date 5/11/2021
 **/
public class CountDownLatchDemo {
    public static void main(String[] args) {

    }
}

/**
 * 第一个是开始信号，防止工人工作，只有等到司机做好准备为止
 * 第二个是完成信号，驾驶员等到所有工人工作完成才可以操作。
 */
class Driver {

    private final static int N = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        ExecutorService executorService = Executors.newFixedThreadPool(N);

        for (int i = 0; i < N; ++i)
        {
            executorService.execute(new Worker(startSignal, doneSignal));
        }

        // don't let run yet
        System.out.println("司机正在做准备~~~~");
        // let all threads proceed
        startSignal.countDown();
        System.out.println("司机做好了准备~~~~");
        // wait for all to finish
        doneSignal.await();
        System.out.println("所有工人已经工作完毕，司机可以操作了");
    }
}

/**
 * 工作
 */
class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            startSignal.await();
            doWork();
        } catch (InterruptedException ignored) {

        } finally {
            doneSignal.countDown();
        }
    }

    void doWork() {
        System.out.println("touch fish! !");
    }
}

/**
 * doneSignal，计算完毕的信号；
 * addSignal，每次添加一个数的信号(主要是下面的计算可能导致添加的数部分丢失，
 *      因为CAS每次只能成功一个， 并没有作设置失败的处理)
 */
class Driver2 {
    private static final int N = 10;
    public static final  AtomicInteger RESULT = new AtomicInteger();

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        CountDownLatch doneSignal = new CountDownLatch(N);

        ExecutorService e = Executors.newFixedThreadPool(N);

        Future<Integer> future = null;

        // create and start threads
        for (int i = 0; i < N; ++i)
        {
            CountDownLatch addSignal = new CountDownLatch(1);
            future = e.submit(new WorkerRunnable(addSignal, doneSignal, i));
            addSignal.await();
        }

        System.out.println("等待计算~");
        doneSignal.await();           // wait for all to finish
        System.out.println("计算完毕🎈");
        System.out.println("结果: " + future.get());
        e.shutdown();

    }
}

class WorkerRunnable implements Callable<Integer> {
    private final CountDownLatch doneSignal;
    private final CountDownLatch addSignal;

    private final int i;

    WorkerRunnable(CountDownLatch addSignal, CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.addSignal = addSignal;
        this.i = i;
    }

    Integer doWork(int i) {

        int result = Driver2.RESULT.addAndGet(i);
        addSignal.countDown();
        return result;
    }

    @Override
    public Integer call() {
        doneSignal.countDown();
        return doWork(i);
    }
}
