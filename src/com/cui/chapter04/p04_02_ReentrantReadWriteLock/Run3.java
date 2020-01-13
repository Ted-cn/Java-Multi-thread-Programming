package com.cui.chapter04.p04_02_ReentrantReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyService3 {
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
 * 4.2.3 ReentrantReadWriteLock类的使用：读写互斥/写读互斥
 */
public class Run3 {
    public static void main(String[] args) {
        MyService3 service = new MyService3();
        new Thread(() -> {
            service.write();
        }, "A").start();
        new Thread(() -> {
            service.read();
        }, "B").start();
    }
}
