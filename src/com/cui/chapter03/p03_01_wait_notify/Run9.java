package com.cui.chapter03.p03_01_wait_notify;

/**
 * 3.1.9 通知过早
 *
 * 如果通知过早，则会打乱程序正常的运行逻辑
 */
public class Run9 {
    private static String lock = new String("");
    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("begin wait");
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("end wait");
            }
        }, "a").start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("notify begin timer=" + System.currentTimeMillis());
                lock.notify();
                System.out.println("notify end timer=" + System.currentTimeMillis());
            }
        }, "b").start();
    }
}
