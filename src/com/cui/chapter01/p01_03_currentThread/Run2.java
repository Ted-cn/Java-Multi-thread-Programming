package com.cui.chapter01.p01_03_currentThread;

class MyThread extends Thread {
    public MyThread() {
        System.out.println("构造方法的打印： " + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run()方法的打印： " + Thread.currentThread().getName());
    }
}

public class Run2 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        //myThread.start(); // 构造方法的打印： main    run()方法的打印： Thread-0
        myThread.run(); // 构造方法的打印： main    run()方法的打印： main
    }
}
