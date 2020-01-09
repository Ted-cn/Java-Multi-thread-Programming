package com.cui.chapter01.p01_07_stop_thread;

class MyThread8 extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println(i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 使用stop()方法停止线程是非常暴力的
 *
 * 调用stop()方法会抛出java.lang.ThreadDeath异常，但通常情况下该异常不需要显式地捕捉。
 *
 * stop()方法已经被作废，因为如果强制让线程停止，
 * 1. 可能会使一些清理性的工作得不到完成。
 * 2. 另外一个情况就是对锁定的对象进行了“解锁”，导致数据得不到同步的处理，出现数据不一致的问题。
 */
public class Run8 {
    public static void main(String[] args) {
        try {
            MyThread8 thread = new MyThread8();
            thread.start();
            Thread.sleep(8000);
            thread.stop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
