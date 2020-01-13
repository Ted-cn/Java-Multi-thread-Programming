package com.cui.chapter07.p07_01_statusOfThread;

class MyService3 {
    synchronized static public void serviceMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + "进入了业务方法");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 7.1.3 验证BLOCKED
 *
 * BLOCKED状态在某一线程等待锁时出现
 */
public class Run3 {
    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            MyService3.serviceMethod();
        }, "A");
        a.start();
        Thread b = new Thread(() -> {
            MyService3.serviceMethod();
        }, "B");
        b.start();
        System.out.println(a.getName() + "\t "+ a.getState());
        System.out.println(b.getName() + "\t "+ b.getState());
    }
}
