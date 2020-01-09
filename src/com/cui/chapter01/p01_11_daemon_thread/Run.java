package com.cui.chapter01.p01_11_daemon_thread;

class MyThread extends Thread {
    private int i = 0;
    @Override
    public void run() {
        try {
            while (true) {
                i++;
                System.out.println("i=" + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 在Java中有两种线程，一种是用户线程，另一种是守护线程
 *
 * 守护线程是一种特殊的线程，它的特性有“陪伴”的含义，当进程中不存在非守护线程时，守护线程自然销毁。
 * 典型的守护线程就是垃圾回收线程，当进程中没有非守护线程了，则垃圾回收线程也就没有存在的必要了，就自动销毁。
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.setDaemon(true);
            thread.start();
            Thread.sleep(5000);
            System.out.println("main离开了，thread对象也不再打印了，也就是停止了！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
