package com.cui.chapter01.p01_07_stop_thread;

public class Run3 {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            // 不清除中断状态
            System.out.println("是否停止1？= " + thread.isInterrupted());  // true
            System.out.println("是否停止2？= " + thread.isInterrupted());  // true
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
