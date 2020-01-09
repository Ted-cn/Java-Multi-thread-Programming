package com.cui.chapter01.p01_02_Thread_Runnable;

class MyThread04 extends Thread {
    private int count = 5;

    public MyThread04(String name) {
        super();
        this.setName(name);
    }

    @Override
    public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println("由" + Thread.currentThread().getName() + "计算，count = " + count);
        }
    }
}

/**
 * 线程之间不共享的数据
 */
public class MyThread04Demo {
    public static void main(String[] args) {
        MyThread04 a = new MyThread04("A");
        MyThread04 b = new MyThread04("B");
        MyThread04 c = new MyThread04("C");
        a.start();
        b.start();
        c.start();
    }
}
