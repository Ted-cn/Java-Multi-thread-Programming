package com.cui.chapter01.p01_04_isAlive;

class CountOperate extends Thread {
    /**
     * 在普通方法中，this代表方法的调用者，即调用本方法的对象
     * 在构造方法中，this代表该创建方法本次运行所创建的新对象
     */
    public CountOperate() {
        System.out.println("CountOperate---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());  // main
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());  // true
        System.out.println("this.getName() = " + this.getName());  // Thread-0
        System.out.println("this.isAlive() = " + this.isAlive());  // false
        System.out.println("CountOperate---end");
    }

    @Override
    public void run() {
        System.out.println("run---begin");
        System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());  // A
        System.out.println("Thread.currentThread().isAlive() = " + Thread.currentThread().isAlive());  // true
        System.out.println("this.getName() = " + this.getName());  // Thread-0 !
        // run() 的调用者始终是 Thread-0
        System.out.println("this.isAlive() = " + this.isAlive());  // false !
        System.out.println("run---end");
    }
}

public class Run2 {
    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive = " + t1.isAlive());  // false
        t1.setName("A");
        t1.start();
        System.out.println("main begin t1 isAlive = " + t1.isAlive());  // true
    }
}
