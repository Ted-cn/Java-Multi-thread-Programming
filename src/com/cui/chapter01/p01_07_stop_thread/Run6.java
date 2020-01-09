package com.cui.chapter01.p01_07_stop_thread;

class MyThread6 extends Thread {
    @Override
    public void run() {
        super.run();
        try {
            System.out.println("run begin");
            Thread.sleep(200000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("在沉睡中被停止！进入catch!" + this.isInterrupted());
            e.printStackTrace();
        }
    }
}

/**
 * java.lang.InterruptedException: sleep interrupted
 *
 * 如果在sleep状态下停止某一线程，会进入catch语句，并且清除停止状态值，使之成为false。
 */
public class Run6 {
    public static void main(String[] args) {
        MyThread6 myThread6 = new MyThread6();
        myThread6.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThread6.interrupt();
        System.out.println("end!");
    }
}
