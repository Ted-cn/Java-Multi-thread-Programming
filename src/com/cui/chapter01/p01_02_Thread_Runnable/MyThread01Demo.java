package com.cui.chapter01.p01_02_Thread_Runnable;

class MyThread01 extends Thread {
    @Override
    public void run() {
        super.run();
        System.out.println("MyThread01");
    }
}

public class MyThread01Demo {
    public static void main(String[] args) {
        MyThread01 myThread = new MyThread01();
        myThread.start();
        /** 这里如果多次调用start()方法，则会出现java.lang.IllegalThreadStateException */
        System.out.println("运行结束！");
    }
}
