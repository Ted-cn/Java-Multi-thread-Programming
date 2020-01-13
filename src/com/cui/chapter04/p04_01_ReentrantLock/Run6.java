package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService6 {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
    public void awaitB() {
        try {
            lock.lock();
            System.out.println("begin awaitB时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }
    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 4.1.6 使用多个Condition实现通知部分线程：正确用法
 */
public class Run6 {
    public static void main(String[] args) throws InterruptedException {
        MyService6 service = new MyService6();
        new Thread(() -> {
            service.awaitA();
        }, "A").start();
        new Thread(() -> {
            service.awaitB();
        }, "B").start();
        Thread.sleep(3000);
        service.signalAll_A();
    }
}
