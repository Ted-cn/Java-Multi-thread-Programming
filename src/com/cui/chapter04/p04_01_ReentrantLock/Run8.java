package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService8 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                System.out.println("有可能11连续");
                condition.await();
            }
            System.out.println("打印1");
            hasValue = true;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (!hasValue) {
                System.out.println("有可能00连续");
                condition.await();
            }
            System.out.println("打印0");
            hasValue = false;
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 实现生产者/消费者：多对多交替打印
 */
public class Run8 {
    public static void main(String[] args) {
        MyService8 service = new MyService8();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    service.set();
                }
            }).start();
            new Thread(() -> {
                for (int j = 0; j < 10; j++) {
                    service.get();
                }
            }).start();
        }

    }
}
