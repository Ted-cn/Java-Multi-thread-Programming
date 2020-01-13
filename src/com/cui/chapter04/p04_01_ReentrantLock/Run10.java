package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

class Service10 {
    private ReentrantLock lock = new ReentrantLock();
    public void m1() {
        try {
            lock.lock();
            System.out.println("m1 getHoldCount=" + lock.getHoldCount());
            m2();
        } finally {
          lock.unlock();
        }
    }

    public void m2() {
        try {
            lock.lock();
            System.out.println("m2 getHoldCount=" + lock.getHoldCount());
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 4.1.10 getHoldCount()方法、getQueueLength()方法和getWaitQueueLength()
 *
 * getHoldCount()方法的作用是查询当前线程保持此锁定的个数，也就是调用lock()方法的次数
 *
 * getQueueLength()方法的作用是返回正等待获取此锁的线程估计数
 *
 * getWaitQueueLength()方法的作用是返回等待与此锁相关的给定条件Condition的线程估计数
 */
public class Run10 {
}
