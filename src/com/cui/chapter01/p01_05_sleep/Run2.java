package com.cui.chapter01.p01_05_sleep;

public class Run2 {
    public static void main(String[] args) {
        MyThread1 myThread1 = new MyThread1();
        System.out.println("begin = " + System.currentTimeMillis());
        // 调用start()方法，异步执行，先打印begin，end，再打印run threadName
        myThread1.start();
        System.out.println("end = " + System.currentTimeMillis());
    }
}
