package com.cui.chapter01.p01_08_suspend_thread;

class MyThread3 extends Thread {
    private int i = 0;
    @Override
    public void run() {
        while (true){
            i++;
            /**
             * 这里需要注意的是println()方法内部也是加锁的，如果此处打印的话，
             * thread1停止时会独占这把锁，导致main线程无法打印。
             */
            //System.out.println(i);
        }
    }
}

public class Run3 {
    public static void main(String[] args) {
        MyThread3 thread1 = new MyThread3();
        thread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.suspend();
        System.out.println("main end!");
    }
}
