package com.cui.chapter01.p01_02_Thread_Runnable;

class MyThread05 extends Thread {
    private int count = 5000;

    /**
     * 通过在run方法前加入synchronized关键字，使多个线程在执行run()方法时，
     * 以排除的方式进行处理，当一个线程调用run()方法前，先判断run()方法没有
     * 被上锁，如果上锁，说明有其他线程正在调用run()方法，必须等待其他线程调
     * 用结束后才可以执行run()方法。
     *
     * synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为“互斥区”
     * 或“临界区”。
     *
     * 当一个线程想要执行同步方法里的代码时，会首先尝试去拿这把锁，如果能拿到，
     * 则执行synchronized里面的代码。如果不能，那么这个线程会不断地尝试拿这把
     * 锁，直到能够拿到为止。并且，多个线程会同时争取同一把锁。
     */
    @Override
    synchronized public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算，count = " + count);
        }
    }
}

/**
 * 线程之间数据共享
 */
public class MyThread05Demo {
    public static void main(String[] args) {
        MyThread05 myThread = new MyThread05();
        Thread a = new Thread(myThread, "A");
        Thread b = new Thread(myThread, "B");
        Thread c = new Thread(myThread, "C");
        Thread d = new Thread(myThread, "D");
        Thread e = new Thread(myThread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
