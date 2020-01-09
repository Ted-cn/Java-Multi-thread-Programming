package com.cui.chapter02.p02_01_synchronized_method;

class Lock {
    private boolean isLocked = false;
    synchronized public void lock() {
        try {
            while (isLocked) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isLocked = true;
    }

    synchronized public void unlock() {
        isLocked = false;
        notify();
    }
}

class Count {
    Lock lock = new Lock();
    public void print() {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    public void doAdd() {
        lock.lock();
        System.out.println("doAdd()");
        lock.unlock();
    }
}

/**
 * 不可重入锁
 */
public class Run6_2 {
    public static void main(String[] args) {
        Count count = new Count();
        new Thread(() -> { count.print(); }, "A").start();
        new Thread(() -> { count.print(); }, "B").start();
    }
}
