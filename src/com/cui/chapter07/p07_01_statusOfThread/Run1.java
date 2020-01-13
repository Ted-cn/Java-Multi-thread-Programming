package com.cui.chapter07.p07_01_statusOfThread;

class MyThread1 extends Thread {
    public MyThread1() {
        System.out.println("构造方法中的状态：" + this.getState());  // NEW
    }

    @Override
    public void run() {
        System.out.println("run()方法中的状态：" + Thread.currentThread().getState());  // RUNNABLE
    }
}

/**
 * 7.1.1 验证NEW、RUNNABLE和TERMINATED
 *
 * NEW是线程实例化后还从未执行start()方法时的状态
 *
 * RUNNABLE是线程进入运行的状态
 *
 * TERMINATED是线程被销毁时的状态
 */
public class Run1 {

    public static void main(String[] args) {
        try {
            MyThread1 t = new MyThread1();
            System.out.println("main方法中的状态1：" + t.getState());  // NEW
            Thread.sleep(1000);
            t.start();
            System.out.println("main方法中的状态2：" + t.getState());  // RUNNABLE
            Thread.sleep(1000);
            System.out.println("main方法中的状态3：" + t.getState());  // TERMINATED
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
