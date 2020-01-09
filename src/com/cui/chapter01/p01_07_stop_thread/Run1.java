package com.cui.chapter01.p01_07_stop_thread;

/**
 * 判断线程的状态是不是停止的
 * 1. this.interrupted()：测试当前线程已经中断
 *     public static boolean interrupted()
 *
 * 2. this.isInterrupted()：测试线程已经中断
 *     public boolean isInterrupted()
 */
public class Run1 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //Thread.currentThread().interrupt();
            // interrupted测试的是当前线程是否中断，而当前线程是main线程，一直没有中断，所以返回二个都是false
            System.out.println("是否停止1？= " + thread.interrupted());  // false
            System.out.println("是否停止2？= " + thread.interrupted());  // false
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
