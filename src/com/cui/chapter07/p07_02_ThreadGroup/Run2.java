package com.cui.chapter07.p07_02_ThreadGroup;

/**
 * 7.2.2 线程对象关联线程组：多级关联
 */
public class Run2 {
    public static void main(String[] args) {
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
        ThreadGroup group = new ThreadGroup(mainGroup, "A");
        Thread a = new Thread(() -> {
            System.out.println("runMethod");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread newThread = new Thread(group, a, "Z");
        newThread.start();
    }
}
