package com.cui.chapter01.p01_08_suspend_thread;



class SynchronizedObject {
    synchronized public void printString() {
        System.out.println("begin");
        if (Thread.currentThread().getName().equals("a")) {
            System.out.println("a 线程永远suspend了！");
            Thread.currentThread().suspend();
        }
    }
}
/**
 * suspend与resume方法的缺点——独占
 *
 */
public class Run2 {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);

            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2启动了，但进入不了printString()方法！只打印了一个begin。");
                    System.out.println("因为printString()被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
