package com.cui.chapter04.p04_02_ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyService1 {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void read() {
        try {
            lock.readLock().lock();
            System.out.println("获得读锁" + Thread.currentThread().getName() + "\t" + System.currentTimeMillis());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }
}

/**
 * 4.2.1 ReentrantReadWriteLock类的使用：读读共享
 *
 */
public class Run1 {
    public static void main(String[] args) {
        MyService1 service = new MyService1();
        new Thread(() -> {
            service.read();
        }, "A").start();
        new Thread(() -> {
            service.read();
        }, "B").start();
    }
}
