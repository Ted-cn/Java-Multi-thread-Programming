package com.cui.chapter03.p03_01_wait_notify;

class Service {
    public void testMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin wait()");
            try {
                //lock.wait();
                lock.notify();
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait()");
        }
    }
}

/**
 * 3.1.4 wait()方法锁释放和notify()方法锁不释放
 *
 * 当wait()方法执行后，锁被自动释放，但notify()方法释放后，锁却不自动释放。
 */
public class Run4 {
    public static void main(String[] args) {
        Object lock = new Object();

        new Thread(() -> {
            Service service = new Service();
            service.testMethod(lock);
        }, "a").start();

        new Thread(() -> {
            Service service = new Service();
            service.testMethod(lock);
        }, "b").start();
    }
}
