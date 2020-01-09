package com.cui.chapter01.p01_03_currentThread;

class CountOperate extends Thread {
    /**
     * 在普通方法中，this代表方法的调用者，即调用本方法的对象
     * 在构造方法中，this代表该创建方法本次运行所创建的新对象
     */
    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
        System.out.println("this.getName() = " + this.getName());
        System.out.println("run---end");
    }
}

public class Run3 {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        t1.setName("A");
        t1.start();
    }
}
