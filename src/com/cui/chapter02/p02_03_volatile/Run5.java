package com.cui.chapter02.p02_03_volatile;

import java.util.concurrent.atomic.AtomicInteger;

class AddCountThread extends Thread {
    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(count.incrementAndGet());
        }
    }
}

/**
 * 2.3.5 使用原子类进行i++操作
 *
 * 原子操作是不能分割的整体，没有其他线程能够中断或检查正在原子操作中的变量。
 * 一个原子(atomic)类型就是一个原子操作可用的类型，它可以在没有锁的情况下
 * 做到线程安全。
 */
public class Run5 {
    public static void main(String[] args) {
        AddCountThread countService = new AddCountThread();
        Thread t1 = new Thread(countService);
        Thread t2 = new Thread(countService);
        Thread t3 = new Thread(countService);
        Thread t4 = new Thread(countService);
        Thread t5 = new Thread(countService);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
