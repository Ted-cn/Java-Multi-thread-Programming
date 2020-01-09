package com.cui.chapter02.p02_03_volatile;

class Service7 {
    private boolean isContinueRun = true;

    public void runMethod() {
        while (isContinueRun) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //System.out.println("停下来了！");
    }
    public void stopMethod() {
        isContinueRun = false;
    }
}

/**
 * 2.3.7 synchronized代码块有volatile同步的功能
 *
 * synchronized关键字可以使多个线程访问同一个资源具有同步性，而且它还具有将线程
 * 工作内存中的私有变量与公共内存中的变量同步的功能。
 *
 * synchronized关键字可以保证在同一时刻，只有一个线程可以执行某一个方法或某一个代码块。
 * 它包含两个特征：互斥性和可见性。同步synchronized不仅可以解决一个线程看到对象处于不
 * 一致的状态，还可以保证进入同步方法或者同步代码块的每个线程，都可以看到由同一个锁保护
 * 之前所有的修改效果。
 */
public class Run7 {
    public static void main(String[] args) {
        Service7 service = new Service7();
        new Thread(() -> {service.runMethod();}, "A").start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(() -> {service.stopMethod();}, "B").start();
        //System.out.println("已经发起停止的命令了！");
    }
}
