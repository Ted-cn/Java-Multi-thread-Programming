package com.cui.chapter01.p01_02_Thread_Runnable;

class MyThread03 extends Thread {
    private int i;

    public MyThread03(int i) {
        super();
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(i);
    }
}

/**
 * 举例说明：执行start()方法的顺序，并不代表线程启动的顺序。
 */
public class MyThread03Demo {
    public static void main(String[] args) {
        new MyThread03(1).start();
        new MyThread03(2).start();
        new MyThread03(3).start();
        new MyThread03(4).start();
        new MyThread03(5).start();
        new MyThread03(6).start();
        new MyThread03(7).start();
        new MyThread03(8).start();
        new MyThread03(9).start();
        new MyThread03(10).start();
        new MyThread03(11).start();;
        new MyThread03(12).start();
        new MyThread03(13).start();
    }
}
