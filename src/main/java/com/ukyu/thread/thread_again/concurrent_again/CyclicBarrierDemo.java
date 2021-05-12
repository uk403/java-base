package com.ukyu.thread.thread_again.concurrent_again;

import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 *
 * 循环屏障demo
 * @author ukyu
 * @time 2021/5/11 23:52
 */
public class CyclicBarrierDemo {
}

/**
 * 每个线程处理一行数据，最后打印出来；一直重复
 */
class Solver {
    final int N;
    static final float[][] DATA = new float[2][2];
    final CyclicBarrier barrier;

    public Solver(float[][] matrix) {

        N = matrix.length;
        Runnable barrierAction =
                this::mergeRows;
        barrier = new CyclicBarrier(N, barrierAction);

        for (int i = 0; i < N; i++) {
            Thread thread = new Thread(new Worker(i, barrier));
            thread.start();
        }
    }

    public void mergeRows() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {

        }
        System.out.println("处理后的DATA: " + Arrays.deepToString(DATA));
    }

    public static void main(String[] args) throws InterruptedException {
        Arrays.fill(DATA[0], 1);
        Arrays.fill(DATA[1], 2);
        System.out.println("处理前的DATA: " + Arrays.deepToString(DATA));

        new Solver(DATA);

    }

    static class Worker implements Runnable {
        int myRow;
        CyclicBarrier barrier;

        Worker(int row, CyclicBarrier barrier) {
            myRow = row;
            this.barrier = barrier;
        }
        @Override
        public void run() {
            while (true) {
            processRow(myRow);

                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException ignored) {}
            }
        }

        public void processRow(int myRow){
            Arrays.fill(DATA[myRow], DATA[myRow][0] + 2);
        }
    }

}