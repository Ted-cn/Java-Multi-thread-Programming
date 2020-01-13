package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService5 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void awaitA() {
        try {
            lock.lock();
            System.out.println("begin awaitA时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            condition.await();
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
            condition.await();
            System.out.println("end awaitB时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
        } catch (InterruptedException e) {

        } finally {
            lock.unlock();
        }
    }
    public void signalAll() {
        try {
            lock.lock();
            System.out.println("signalAll时间为：" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 4.1.5 使用多个Condition实现通知部分线程：错误用法
 *
 */
public class Run5 {
    public static void main(String[] args) throws InterruptedException {
        MyService5 service = new MyService5();
        new Thread(() -> {
            service.awaitA();
        }).start();
        new Thread(() -> {
            service.awaitB();
        }).start();
        Thread.sleep(3000);
        service.signalAll();
    }
}
