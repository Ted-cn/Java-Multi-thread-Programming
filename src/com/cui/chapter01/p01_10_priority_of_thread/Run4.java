package com.cui.chapter01.p01_10_priority_of_thread;

import java.util.Random;

class MyThread3 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random= new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 3 use time=" + (endTime- beginTime) + "毫秒");
    }
}

class MyThread4 extends Thread {
    @Override
    public void run() {
        long beginTime = System.currentTimeMillis();
        long addResult = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 50000; j++) {
                Random random= new Random();
                random.nextInt();
                addResult = addResult + i;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("thread 4 use time=" + (endTime- beginTime) + "毫秒");
    }
}

/**
 * 优先级具有规则性
 *
 * 虽然使用setPriority()方法可以设置线程的优先级，
 * 但还没有看到设置优先级所带来的效果。
 *
 * 高优先级的线程总是大部分先执行完，
 * 但并不代表高优先级的线程会全部先执行完。
 */
public class Run4 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            MyThread3 myThread3 = new MyThread3();
            myThread3.setPriority(Thread.MAX_PRIORITY);
            myThread3.start();
            MyThread4 myThread4 = new MyThread4();
            myThread4.setPriority(Thread.MIN_PRIORITY);
            myThread4.start();
        }
    }
}
