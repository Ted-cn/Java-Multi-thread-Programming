package com.cui.chapter03.p03_02_join;

class ThreadA3 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String newString = new String();
            Math.random();
        }
    }
}

class ThreadB3 extends Thread {
    @Override
    public void run() {
        try {
            ThreadA3 a = new ThreadA3();
            a.start();
            a.join();
            System.out.println("线程B在run end处打印了");
        } catch (InterruptedException e) {
            System.out.println("线程B在catch处打印了");
            e.printStackTrace();
        }
    }
}

class ThreadC3 extends Thread {
    private ThreadB3 threadB3;

    public ThreadC3(ThreadB3 threadB3) {
        this.threadB3 = threadB3;
    }

    @Override
    public void run() {
        threadB3.interrupt();
    }
}

/**
 * 3.2.3 方法join与异常
 *
 * 在join过程中，如果当前线程对象被中断，则当前线程出现异常
 */
public class Run3 {
    public static void main(String[] args) {
        try {
            ThreadB3 b3 = new ThreadB3();
            b3.start();
            Thread.sleep(500);
            ThreadC3 c3 = new ThreadC3(b3);
            c3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
