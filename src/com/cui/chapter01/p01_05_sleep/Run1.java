package com.cui.chapter01.p01_05_sleep;

/**
 * sleep()方法的作用是在指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）。
 * 正在执行的线程是指this.currentThread()返回的线程。
 */
class MyThread1 extends Thread {
    @Override
    public void run() {
        System.out.println("run threadName = " + this.currentThread().getName() + " begin");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("run threadName = " + this.currentThread().getName() + " end");
    }
}

public class Run1 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin = " + System.currentTimeMillis());
        // 直接调用run()方法，同步执行，打印的都是main线程
        myThread1.run();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
