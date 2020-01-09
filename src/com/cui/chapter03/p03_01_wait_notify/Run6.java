package com.cui.chapter03.p03_01_wait_notify;

class Service6 {
    public void test(Object lock) {
        synchronized (lock) {
            System.out.println("begin wait() ThreadName=" + Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait() ThreadName=" + Thread.currentThread().getName());
        }
    }
}

/**
 * 3.1.6 只通知一个线程
 *
 * 调用notify()方法一次只随机通知一个线程进行唤醒
 *
 * 调用notifyAll()方法唤醒全部线程（注意唤醒以后线程可能还会出现争抢）
 */
public class Run6 {
    public static void main(String[] args) {
        Object lock = new Object();
        new Thread(() -> {
            new Service6().test(lock);
        }, "A").start();

        new Thread(() -> {
            new Service6().test(lock);
        }, "B").start();

        new Thread(() -> {
            new Service6().test(lock);
        }, "C").start();

        new Thread(() -> {
            synchronized (lock) {
                lock.notifyAll();
            }
        }, "notifyThread").start();
    }
}
