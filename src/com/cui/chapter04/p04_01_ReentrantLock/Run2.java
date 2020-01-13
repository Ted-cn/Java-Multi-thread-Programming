package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService2 {
    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodA end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println("methodA begin ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            Thread.sleep(3000);
            System.out.println("methodA end ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 4.1.2 使用ReentrantLock实现同步：测试2
 *
 */
public class Run2 {
    public static void main(String[] args) {
        MyService2 service = new MyService2();
        new Thread(() -> {
            service.methodA();
        }, "A").start();
        new Thread(() -> {
            service.methodA();
        }, "AA").start();
        new Thread(() -> {
            service.methodB();
        }, "B").start();
        new Thread(() -> {
            service.methodB();
        }, "BB").start();
    }
}
