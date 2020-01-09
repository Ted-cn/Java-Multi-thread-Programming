package com.cui.chapter02.p02_03_volatile;

class MyThread4 extends Thread {
    volatile public static int count;

    synchronized private static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count=" + count);
    }

    @Override
    public void run() {
        addCount();
    }
}

/**
 * 2.3.4 volatile非原子的特性
 *
 * volatile关键字主要使用的场合是在多个线程中可以感知实例变量被更改了，
 * 并且可以获得最新的值使用，也就是用多线程读取共享变量时可以获得最新值使用。
 *
 */
public class Run4 {
    public static void main(String[] args) {
        MyThread4[] myThreadArray = new MyThread4[100];
        for (int i = 0; i < 100; i++) {
            myThreadArray[i] = new MyThread4();
        }
        for (int i = 0; i < 100; i++) {
            myThreadArray[i].start();
        }
    }
}
