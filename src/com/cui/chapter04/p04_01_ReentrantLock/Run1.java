package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService1 {
    private Lock lock = new ReentrantLock();
    public void test() {
        lock.lock();
        for (int i = 0; i < 5; i++) {
            System.out.println("ThreadName=" + Thread.currentThread().getName() + "\t" + (i + 1));
        }
        lock.unlock();
    }
}

class MyThread1 extends Thread {
    private MyService1 service;

    public MyThread1(MyService1 service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.test();
    }
}

/**
 * 4.1.1 使用ReentrantLock实现同步：测试1
 *
 */
public class Run1 {
    public static void main(String[] args) {
        MyService1 service = new MyService1();
        MyThread1 a1 = new MyThread1(service);
        MyThread1 a2 = new MyThread1(service);
        MyThread1 a3 = new MyThread1(service);
        MyThread1 a4 = new MyThread1(service);
        MyThread1 a5 = new MyThread1(service);
        a1.start();
        a2.start();
        a3.start();
        a4.start();
        a5.start();
    }
}






















