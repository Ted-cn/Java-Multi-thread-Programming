package com.cui.chapter03.p03_01_wait_notify;

class Service5 {
    public void testMethod5(Object lock) {
        synchronized (lock) {
            System.out.println("being wait()");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait()");
        }
    }
}

/**
 * 当interrupt()方法遇到wait()方法
 *
 * 当线程呈wait()状态时，调用线程对象的interrupt()方法会出现java.lang.InterruptedException异常
 */
public class Run5 {
    public static void main(String[] args) {
        Object lock = new Object();
        Thread a = new Thread(() -> {
            Service5 service = new Service5();
            service.testMethod5(lock);
        }, "a");
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }
    /**
     * 总结：
     * 1. 执行完同步代码块就会释放对象的锁
     * 2. 在执行同步代码的过程中，遇到异常而导致线程终止，锁也会被释放
     * 3. 在执行同步代码的过程中，执行了锁所属对象的wait()方法，这个线程会释放对象锁，
     *    而此线程对象会进入线程等待池中，等待被唤醒。
     */
}
