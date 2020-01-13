package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class MyService13 {
    private ReentrantLock lock = new ReentrantLock();
    public void waitMethod() {
        if (lock.tryLock()) {
            System.out.println(Thread.currentThread().getName() + "获得锁");
        } else {
            System.out.println(Thread.currentThread().getName() + "没有获得锁");
        }
    }
}

/**
 * 4.1.13 lockInterruptibly()方法、tryLock()方法和tryLock(long timeout, TimeUnit unit)
 *
 * void lockInterruptibly()的作用是如果当前线程未被中断，则获取锁定；如果已经被中断，则出现异常
 *
 * boolean tryLock()的作用是仅在调用时锁定未被另一线程保持的情况下，才获取该锁定。
 *
 * boolean tryLock(long timeout, TimeUnit unit)的作用是，如果锁定在给定等待时间内没有被另一个线程保持，
 * 且当前线程未被中断，则获取该锁定。
 */
public class Run13 {
    public static void main(String[] args) {
        MyService13 service = new MyService13();
        new Thread(() -> {
            service.waitMethod();
        }, "A").start();
        new Thread(() -> {
            service.waitMethod();
        }, "B").start();
    }
}
