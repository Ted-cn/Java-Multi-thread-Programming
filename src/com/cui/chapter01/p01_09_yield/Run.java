package com.cui.chapter01.p01_09_yield;

class MyThread extends Thread {
    @Override
    public void run() {
        long begin = System.currentTimeMillis();
        int count = 0;
        for (int i = 0; i < 50000000; i++) {
            Thread.yield();
            count = count + (i + 1);
        }
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - begin) + "毫秒");
    }
}

/**
 * yield()方法的作用是放弃当前的CPU资源，将它让给其他的任务去使用。
 * 但放弃的时间不确定，有可能刚刚放弃，马上又获得CPU时间片。
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
        System.out.println("end");
    }
}

