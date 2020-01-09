package com.cui.chapter03.p03_01_wait_notify;

/**
 * 3.1.8 方法wait(long)的使用
 *
 * 带一个参数的wait(long)方法的功能是等待某一时间内是否有线程对锁进行唤醒，
 * 如果超过这个时间则自动唤醒。
 */
public class Run8 {

    static private Object lock = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock) {
                System.out.println("wait begin timer=" + System.currentTimeMillis());
                try {
                    lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("wait end timer=" + System.currentTimeMillis());
            }
        }).start();
    }
}
