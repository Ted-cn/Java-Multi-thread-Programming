package com.cui.chapter01.p01_04_isAlive;

// isAlive()方法用来判断当前线程是否处于活动状态
// 什么是活动状态？就是线程已经启动且尚未终止。线程处于正在运行或准备开始运行的状态，就认为线程是“存活”的。
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("run = "+ this.isAlive());
    }
}
public class Run {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin == " + myThread.isAlive());
        myThread.start();
        System.out.println("end == " + myThread.isAlive());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after sleep == " + myThread.isAlive());
    }
}
