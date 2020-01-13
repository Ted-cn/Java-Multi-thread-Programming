package com.cui.chapter04.p04_02_ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyService2 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void write() {
        try {
            lock.writeLock().lock();
            System.out.println("获得写锁" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}

/**
 * 4.2.2 ReentrantReadWriteLock类的使用：写写互斥
 *
 */
public class Run2 {
    public static void main(String[] args) {
        MyService2 service = new MyService2();
        new Thread(() -> {
            service.write();
        }, "A").start();
        new Thread(() -> {
            service.write();
        }, "B").start();
    }
}
