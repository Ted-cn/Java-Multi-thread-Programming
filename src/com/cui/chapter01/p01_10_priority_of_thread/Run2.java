package com.cui.chapter01.p01_10_priority_of_thread;

class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread1 run priority=" + this.getPriority());
        this.setPriority(Thread.MAX_PRIORITY);
        System.out.println("MyThread1 run priority=" + this.getPriority());
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread2 run priority=" + this.getPriority());
    }
}

/**
 * 在Java中，线程的优先级具有继承性，
 * 比如A线程启动B线程，则B线程的优先级与A是一样的。
 */
public class Run2 {
    public static void main(String[] args) {
        System.out.println("main thread begin priority=" + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(6);
        System.out.println("main thread end priority=" + Thread.currentThread().getPriority());
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();
    }
}
