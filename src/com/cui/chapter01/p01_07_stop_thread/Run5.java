package com.cui.chapter01.p01_07_stop_thread;

class MyThread5 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            for (int i = 0; i < 500000; i++) {
                if (this.interrupted()) {
                    System.out.println(" 已经是停止状态了，我要退出了！");
                    throw new InterruptedException();
                }
                System.out.println(i + 1);
            }
            System.out.println("我在for下面");
        } catch (InterruptedException e) {
            System.out.println("进MyThread5.java类run方法中的catch了!");
            e.printStackTrace();
        }
    }
}

/**
 * 使用抛出异常的方式，中断线程
 */
public class Run5 {
    public static void main(String[] args) {
        MyThread5 thread = new MyThread5();
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("end!");
    }
}
