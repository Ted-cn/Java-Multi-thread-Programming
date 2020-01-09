package com.cui.chapter01.p01_02_Thread_Runnable;

class MyThread02 extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
                System.out.println("run = " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 演示线程的随机性
 */
public class MyThread02Demo {
    public static void main(String[] args) {
        MyThread02 thread = new MyThread02();
        thread.setName("myThread");
        thread.start();
        for (int i = 0; i < 10; i++) {
            int time = (int) (Math.random() * 1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main = " + Thread.currentThread().getName());
        }
    }
}
