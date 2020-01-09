package com.cui.chapter01.p01_08_suspend_thread;

class MyThread1 extends Thread {
    private long i = 0;

    public long getI() {
        return i;
    }

    public void setI(long i) {
        this.i = i;
    }

    @Override
    public void run() {
        while (true) {
            i++;
        }
    }
}

/**
 * 暂停线程
 *
 * 暂停线程意味着此线程还可以恢复运行。在Java多线程中，
 * 可以使用suspend()方法暂停线程，使用resume()方法恢复线程的执行。
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            MyThread1 thread = new MyThread1();
            thread.start();
            Thread.sleep(2000);
            // A段
            thread.suspend();
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(2000);
            System.out.println("A=" + System.currentTimeMillis() + " i=" + thread.getI());
            // B段
            thread.resume();
            Thread.sleep(2000);
            // C段
            thread.suspend();
            System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
            Thread.sleep(2000);
            System.out.println("B=" + System.currentTimeMillis() + " i=" + thread.getI());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
