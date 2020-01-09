package com.cui.chapter01.p01_10_priority_of_thread;

import java.util.Random;

class MyThread5 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            Random random = new Random();
            random.nextInt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 5 use time=" + (endTime- beginTime) + "毫秒");
    }
}

class MyThread6 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Random random= new Random();
            random.nextInt();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 6 use time=" + (endTime- beginTime) + "毫秒");
    }
}

/**
 * 优先级具有随机性
 *
 * 不要把线程的优先级与运行结果的顺序作为衡量的标准，
 * 它们的关系具有不确定性和随机性。
 */
public class Run6 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread5 myThread5 = new MyThread5();
            myThread5.setPriority(5);
            myThread5.start();
            MyThread6 myThread6 = new MyThread6();
            myThread6.setPriority(6);
            myThread6.start();
        }
    }
}
