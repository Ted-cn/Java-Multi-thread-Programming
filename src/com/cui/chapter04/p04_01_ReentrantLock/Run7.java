package com.cui.chapter04.p04_01_ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class MyService7 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean hasValue = false;
    public void set() {
        try {
            lock.lock();
            while (hasValue) {
                condition.await();
            }
            System.out.println("打印1");
            hasValue = true;
            condition.signal();
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
                condition.await();
            }
            System.out.println("打印0");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/**
 * 4.1.7 实现生产者/消费者模式：一对一交替打印
 */
public class Run7 {
    public static void main(String[] args) {
        MyService7 service = new MyService7();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                service.set();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                service.get();
            }
        }).start();
    }
}
